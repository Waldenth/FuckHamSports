package org.fuckham;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class Coordinate{
    String longitude; //经度
    String latitude; //维度
    public Coordinate(String longitude,String latitude){
        this.longitude=longitude;
        this.latitude=latitude;
    }
}


public class Configure {
    String imeiCode;
    int versionIndex;
    Coordinate coordinate;
    String runtime;
    String step;
    boolean needSleep;

    public Configure(String imeiCode, int versionIndex, Coordinate coordinate, String runtime, String step, boolean needSleep) {
        this.imeiCode = imeiCode;
        this.versionIndex = versionIndex;
        this.coordinate = coordinate;
        this.runtime = runtime;
        this.step = step;
        this.needSleep = needSleep;
    }
    public Configure(){}


    public static JSONObject toJSONObject(String imeiCode, int versionIndex, Coordinate coordinate, String runtime, String step, boolean needSleep){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("IMEICode",imeiCode);
        jsonObject.put("Version",versionIndex);
        String[] coordinateArray={coordinate.longitude,coordinate.latitude};
        jsonObject.put("Coordinate",coordinateArray);
        jsonObject.put("Runtime",runtime);
        jsonObject.put("Steps",step);
        jsonObject.put("NeedSleep",needSleep);
        return jsonObject;
    }
    public static Configure getConfigureObject(JSONObject jsonObject){
        Configure configure=new Configure();
        configure.imeiCode=jsonObject.get("IMEICode").toString();
        configure.versionIndex=(int)jsonObject.get("Version");
        configure.runtime=jsonObject.get("Runtime").toString();
        configure.step=jsonObject.get("Steps").toString();
        configure.needSleep=(boolean)jsonObject.get("NeedSleep");
        Object[] coordinateArray= ((JSONArray)jsonObject.get("Coordinate")).toList().toArray();
        configure.coordinate=new Coordinate((String)coordinateArray[0],(String)coordinateArray[1]);
        return configure;
    }
}
