package org.fuckham;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class RunFuck {
    private static List<String>alphabet= Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));

    private static String table="";

    public static boolean isRandom=false;

    public static int currProgress=0;

    public static  Random rand = new Random();


    //2021-3-26 2.40版本 有效
    public static String imeiCode;
    public static String version;
    public static String API_ROOT = "http://client3.aipao.me/api";
    public static String API_CUR="/%7Btoken%7D/QM_Users/Login_AndroidSchool?IMEICode=";
    public static String token="";
    public static String userID="";
    public static String timespan="";
    public static String auth="";
    public static String nonce="";
    public static String sign="";
    public static String Lengths="";
    public static String RunId="";
    public static String RunTime="";
    public static String RunDist="";
    public static String RunStep="";
    //获取个人信息的url
    public static String GSurl="";
    //获取开始长跑信息的url
    public static String SRSurl="";
    //发送结束长跑信息的url
    public static String Endurl="";


    public static boolean randomAlphabet(){
        Collections.shuffle(alphabet);
        alphabet=alphabet.subList(0,10);
        StringBuffer tmpTable=new StringBuffer();
        for(int i=0;i<10;i++){
            tmpTable.append(alphabet.get(i));
        }
        table=tmpTable.toString();
        isRandom=true;
        return true;
    }

    public static String getMD5(String s){
        String md5Str="";
        try {
            MessageDigest md5tool=MessageDigest.getInstance("md5");
            md5tool.update(s.getBytes());
            byte[]digest=md5tool.digest();
            md5Str=formatByteArrayTOString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Str;
    }
    public static String formatByteArrayTOString(byte[] digest) {
        //创建sb用于保存md5值
        StringBuffer sb = new StringBuffer();
        int temp;
        for (int i=0;i<digest.length;i++) {
            //将数据转化为0到255之间的数据
            temp = digest[i] & 0xff;
            if (temp < 16) {
                sb.append(0);
            }
            //Integer.toHexString(temp)将10进制数字转换为16进制
            sb.append(Integer.toHexString(temp));
        }
        return sb.toString();
    }

    public static String encrypt(String s){//使用前必须randomAlphabet
        if(isRandom) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                result.append(alphabet.get((int) (curChar - '0')));
            }
            return result.toString();
        }else {
            System.out.println("Error: uninitialized the alphabet");
            return "";
        }
    }

    public static String login(String aimeiCode,String aversion){
        imeiCode=aimeiCode;
        version=aversion;
        //回复
        String response="NULL";
        
        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建 HttpGet 请求
        HttpGet httpGet = new HttpGet(API_ROOT+API_CUR+imeiCode);
        // 设置头 可修改
        httpGet.setHeader("version",version);

        CloseableHttpResponse httpResponse = null;

        try{
            // 请求并获取登录响应信息
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity);
            //解析登录数据的json
            JSONObject jsonObject=new JSONObject(response);
            token=jsonObject.getJSONObject("Data").get("Token").toString();
            userID=jsonObject.getJSONObject("Data").get("UserId").toString();
            timespan = String.valueOf(new Date().getTime());
            auth = "B" + getMD5(getMD5(imeiCode)) + ":;" + token;
            nonce = String.valueOf(rand.nextInt(10000000-100000+1)+100000);
            sign=getMD5(token+nonce+timespan+userID).toUpperCase();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    public static String getUserInfo(){
        //回复
        String response="NULL";

        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        GSurl = API_ROOT + "/" + token + "/QM_Users/GS";
        HttpGet httpGet = new HttpGet(GSurl);
        Header[] headers={
            new BasicHeader("nonce",nonce),
            new BasicHeader("timespan",timespan),
            new BasicHeader("sign",sign),
            new BasicHeader("version",version),
            new BasicHeader("Accept",null),
            new BasicHeader("Accept-Encoding",null),
            new BasicHeader("Connection","Keep-Alive")
        };
        httpGet.setHeaders(headers);
       
        CloseableHttpResponse httpResponse = null;

        try{
            // 请求并获取登录响应信息
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");
            //解析json
            JSONObject jsonObject=new JSONObject(response);
            Lengths=jsonObject.getJSONObject("Data").getJSONObject("SchoolRun").get("Lengths").toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

         return response;
    }


    public static String getRunInfo(int seconds,int steps){
        //回复
        String response="NULL";

        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        SRSurl = API_ROOT + "/" + token + "/QM_Runs/SRS?S1=30.534736&S2=114.367788&S3=" + Lengths;
        HttpGet httpGet = new HttpGet(SRSurl);
        Header[] headers={
            new BasicHeader("nonce",nonce),
            new BasicHeader("timespan",timespan),
            new BasicHeader("sign",sign),
            new BasicHeader("version",version),
            new BasicHeader("Accept",null),
            new BasicHeader("Accept-Encoding",null),
            new BasicHeader("Connection","Keep-Alive")
        };
        httpGet.setHeaders(headers);
       
        CloseableHttpResponse httpResponse = null;

        try{
            // 请求并获取登录响应信息
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");
            //解析json
            JSONObject jsonObject=new JSONObject(response);
            RunId = jsonObject.getJSONObject("Data").get("RunId").toString();
            RunTime = String.valueOf(rand.nextInt(35)+seconds);  // seconds
            RunDist = String.valueOf( Integer.valueOf(Lengths)+ rand.nextInt(4)); 
            RunStep = String.valueOf(rand.nextInt(250)+steps);  // steps
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
         return response;
    }

    public static String getEndRunningInfo(){
        //回复
         String response="NULL";
        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Endurl = API_ROOT + "/" + token + "/QM_Runs/ES?S1=" + RunId + "&S4=" + encrypt(RunTime) + "&S5="
                + encrypt(RunDist) + "&S6=&S7=1&S8=" + table + "&S9=" + encrypt(RunStep);
        HttpGet httpGet = new HttpGet(Endurl);
        Header[] headers={
            new BasicHeader("nonce",nonce),
            new BasicHeader("timespan",timespan),
            new BasicHeader("sign",sign),
            new BasicHeader("version",version),
            new BasicHeader("Accept",null),
            new BasicHeader("Accept-Encoding",null),
            new BasicHeader("Connection","Keep-Alive")
        };
        httpGet.setHeaders(headers);

        CloseableHttpResponse httpResponse = null;
        try{
            // 请求并获取登录响应信息
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");
            //解析json
            JSONObject jsonObject=new JSONObject(response);
            String successInfo=jsonObject.get("Success").toString();
            if(successInfo!=null)
                response=response+"\n成功\n"+jsonObject.get("Data").toString();
            else
                response=response+"\n失败\n"+jsonObject.get("Data").toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }





    // for test or developers , run(.. ,..) can be used in shell terminal
    public static boolean run(String imeiCode,String version){
        if(imeiCode.length()!=32){
            System.out.println("Error: IMEI Format is incorrect");
            return false;
        }


        // 创建 HttpClient 客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建 HttpGet 请求
        HttpGet httpGet = new HttpGet(API_ROOT+API_CUR+imeiCode);
        // 设置头 可修改
        httpGet.setHeader("version",version);

        CloseableHttpResponse httpResponse = null;

        //登录
        try {
            // 请求并获取登录响应信息
            httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String response=EntityUtils.toString(httpEntity);
            // 输出请求结果
            System.out.println(response);
            JSONObject jsonObject=new JSONObject(response);

            String token=jsonObject.getJSONObject("Data").get("Token").toString();
            String userID=jsonObject.getJSONObject("Data").get("UserId").toString();
            String timespan = String.valueOf(new Date().getTime());
            String auth = "B" + getMD5(getMD5(imeiCode)) + ":;" + token;

            Random rand = new Random();
            String nonce = String.valueOf(rand.nextInt(10000000-100000+1)+100000);
            String sign=getMD5(token+nonce+timespan+userID).toUpperCase();

            //System.out.println(token);
            //System.out.println(userID);



            //请求获取用户个人信息
            String GSurl = API_ROOT + "/" + token + "/QM_Users/GS";
            HttpGet httpGetUserInfo = new HttpGet(GSurl);

            Header[] headers={
                    new BasicHeader("nonce",nonce),
                    new BasicHeader("timespan",timespan),
                    new BasicHeader("sign",sign),
                    new BasicHeader("version",version),
                    new BasicHeader("Accept",null),
                    new BasicHeader("Accept-Encoding",null),
                    new BasicHeader("Connection","Keep-Alive")
            };
            httpGetUserInfo.setHeaders(headers);
            httpResponse=httpClient.execute(httpGetUserInfo);
            httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");

            System.out.println(response);

            jsonObject=new JSONObject(response);

            String Lengths = jsonObject.getJSONObject("Data").getJSONObject("SchoolRun").get("Lengths").toString();

            System.out.println(Lengths);

            //Fuck Start
            //请求并获取开始长跑信息
            String SRSurl = API_ROOT + "/" + token + "/QM_Runs/SRS?S1=30.534736&S2=114.367788&S3=" + Lengths;
            HttpGet httpGetRes=new HttpGet(SRSurl);
            httpGetRes.setHeaders(headers);
            httpResponse=httpClient.execute(httpGetRes);

            httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");

            System.out.println(response);

            jsonObject=new JSONObject(response);

            String RunId = jsonObject.getJSONObject("Data").get("RunId").toString();

            //Settings
            String RunTime = String.valueOf(rand.nextInt(1000-720+1)+720);  // seconds
            String RunDist = String.valueOf( Integer.valueOf(Lengths)+ rand.nextInt(4));  // meters
            String RunStep = String.valueOf(rand.nextInt(1600-1300+1)+1300);  // steps
            String EndUrl = API_ROOT + "/" + token + "/QM_Runs/ES?S1=" + RunId + "&S4=" + encrypt(RunTime) + "&S5="
                    + encrypt(RunDist) + "&S6=&S7=1&S8=" + table + "&S9=" + encrypt(RunStep);


            long startTime=new Date().getTime();
            //Fucking...
            for(int i=0;i<Integer.valueOf(RunTime);i++){
                try {
                    Thread.sleep(1000);
                    currProgress++;
                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
                    System.out.print("Running..."+currProgress+"/"+Integer.valueOf(RunTime));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //请求并获取跑步结束信息
            HttpGet httpGetEndRes = new HttpGet(EndUrl);
            httpGetEndRes.setHeaders(headers);
            httpResponse=httpClient.execute(httpGetEndRes);
            httpEntity = httpResponse.getEntity();
            response=EntityUtils.toString(httpEntity,"utf-8");
            jsonObject=new JSONObject(response);
            String successInfo=jsonObject.get("Success").toString();
            if(successInfo!=null)
                System.out.println("\n成功");
            else
                System.out.println("\n失败");

            System.out.println(jsonObject.get("Data").toString());



        } catch (IOException e) {
            e.printStackTrace();
        }
        // 无论如何必须关闭连接
        finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }


    public static void main(String[]args){
        randomAlphabet();
        alphabet.forEach(System.out::print);

        System.out.println("\n"+table);
        System.out.println("\n"+encrypt("123478"));


        //run("b116da51b84d47ee8194216f941de991","2.40");

        String res=login("b116da51b84d47ee8194216f941de991","2.40");
        System.out.println(res);
        //String timespan = String.valueOf(new Date().getTime());
        //System.out.println(timespan);
        //System.out.println(getMD5("123"));
    }

}
