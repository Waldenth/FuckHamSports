/*
 * Created by JFormDesigner on Sat Mar 27 08:36:22 CST 2021
 */

package org.fuckham;

import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author dasd
 */
public class WorkingFrame extends JFrame {
    public WorkingFrame(MainFrame mainFrame,String imeiCode,String version,String seconds,String steps,String longitude,String latitude,boolean needSleep) {
        this.imeiCode=imeiCode;
        this.version=version;
        this.seconds=Integer.parseInt(seconds);
        this.steps=Integer.parseInt(steps);
        this.longtitude=longitude;
        this.latitude=latitude;
        this.needSleep=needSleep;
        //this.returnFrame=mainFrame;
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.setEnabled(true);
            }
        });
        RunFucker runFucker=new RunFucker();
        runFucker.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        progressBar = new JProgressBar();
        scrollPane1 = new JScrollPane();
        logTextArea = new JTextArea();
        exportLogButton = new JButton();
        aboutInfoButton = new JButton();

        //======== this ========
        setTitle("Working...");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/ico.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);

            //---- progressBar ----
            progressBar.setBackground(Color.white);
            progressBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

            //======== scrollPane1 ========
            {

                //---- logTextArea ----
                logTextArea.setBackground(Color.darkGray);
                logTextArea.setForeground(Color.white);
                scrollPane1.setViewportView(logTextArea);
            }

            //---- exportLogButton ----
            exportLogButton.setText("\u5bfc\u51fa\u65e5\u5fd7");
            exportLogButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            exportLogButton.setBackground(Color.darkGray);
            exportLogButton.setForeground(Color.white);

            //---- aboutInfoButton ----
            aboutInfoButton.setText("\u5173\u4e8e");
            aboutInfoButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            aboutInfoButton.setBackground(Color.darkGray);
            aboutInfoButton.setForeground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(exportLogButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(aboutInfoButton)
                        .addGap(70, 70, 70))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(exportLogButton)
                            .addComponent(aboutInfoButton))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        exportLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!completed){
                    JOptionPane.showMessageDialog(null,"还未完成,日志尚未完全生成","提示",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JFileChooser jfc=new JFileChooser();
                    jfc.setSelectedFile(new File(jfc.getCurrentDirectory()+"/log["+formatter.format(new Date(System.currentTimeMillis())).substring(0,10)+"].txt"));
                    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );
                    File file=null;
                    if(jfc.showDialog(new JLabel(), "选择")==JFileChooser.APPROVE_OPTION){
                        file=jfc.getSelectedFile();
                    }
                    //System.out.println(file.getAbsolutePath());
                    if (file != null) {
                        if (!file.isFile()) {
                            try {
                                file.createNewFile();
                            } catch (IOException ioException) {
                                JOptionPane.showMessageDialog(null, "创建文件失败", "错误", JOptionPane.ERROR_MESSAGE);
                                ioException.printStackTrace();
                            }
                        }
                        if (file.isFile()) {
                            String log = logText.toString();
                            FileOutputStream output=null;
                            try {
                                output = new FileOutputStream(file);
                                OutputStreamWriter writer = new OutputStreamWriter(output, "utf-8");
                                writer.write(log);
                                writer.flush();
                                JOptionPane.showMessageDialog(null, "导出日志成功", "提示", JOptionPane.PLAIN_MESSAGE);
                            } catch (IOException ioException) {
                                JOptionPane.showMessageDialog(null, "写入文件失败", "错误", JOptionPane.ERROR_MESSAGE);
                                ioException.printStackTrace();
                            }finally {
                                if(output!=null){
                                    try {
                                        output.close();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                            }
                        }
                    }

                }
            }
        });
        aboutInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutFrame aboutFrame=new AboutFrame();
                aboutFrame.setVisible(true);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JProgressBar progressBar;
    private JScrollPane scrollPane1;
    private JTextArea logTextArea;
    private JButton exportLogButton;
    private JButton aboutInfoButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private final StringBuilder logText = new StringBuilder();
    private final String imeiCode;
    private final String version;
    private final String longtitude;
    private final String latitude;
    private final int seconds;
    private final int steps;
    private final boolean needSleep;
    private boolean completed=false;

    public static String lastErrorResponse="";

    public SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    //private MainFrame returnFrame;

    private class ProgressData{
        private int curSecond;  // 备用
        private String log;
    }


    public class RunFucker extends SwingWorker<StringBuilder,ProgressData> {

        public RunFucker(){

        }

        public StringBuilder doInBackground() throws IOException,InterruptedException {
            RunFuck.randomAlphabet();
            Date date = new Date(System.currentTimeMillis());
            var curProgressData=new ProgressData();
            try{
                logText.append("/** 运行开始 **/\n// ").append(formatter.format(date)).append(" 请求登录信息:\n");
                logText.append(RunFuck.login(imeiCode,version));
                logText.append("\n");

                logText.append("// 请求用户信息:\n");
                logText.append(RunFuck.getUserInfo());
                logText.append("\n");

                System.out.println(RunFuck.RunTime);

                logText.append(RunFuck.getRunInfo(seconds,steps,longtitude,latitude));
                logText.append("\n");

                logText.append(("// 请求跑步信息:\n"));
                if(!needSleep){
                    logText.append("不进行延时模拟\n");
                    progressBar.setMinimum(0);
                    progressBar.setMaximum(2);
                }else{
                    progressBar.setMinimum(0);
                    progressBar.setMaximum(Integer.parseInt(RunFuck.RunTime));
                }


                progressBar.setStringPainted(true);


                if(needSleep) {
                    logText.append("// 开始延时模拟,时间为:").append(Integer.parseInt(RunFuck.RunTime)).append("s ;步数为:").append(Integer.parseInt(RunFuck.RunStep)).append("\n");
                }else{
                    logText.append("// 不进行延时模拟,设置跑步时间为:").append(Integer.parseInt(RunFuck.RunTime)).append("s ;步数为:").append(Integer.parseInt(RunFuck.RunStep)).append("\n");
                }
                curProgressData.curSecond=0;
                curProgressData.log=logText.toString();
                publish(curProgressData);

                int waitTime=needSleep?Integer.parseInt(RunFuck.RunTime):2;

                System.out.println("waittime="+waitTime);

                for(int i = 1; i<waitTime; i++){
                    Thread.sleep(1000);
                    /* 备用
                    curProgressData=new ProgressData();
                    curProgressData.curSecond=i;
                    curProgressData.log="";
                    publish(curProgressData);
                    */
                    progressBar.setValue(i);
                }

                curProgressData=new ProgressData();
                curProgressData.curSecond=Integer.parseInt(RunFuck.RunTime);

                date = new Date(System.currentTimeMillis());

                curProgressData.log="// "+formatter.format(date)+"\n"+RunFuck.getEndRunningInfo()+"\n/** 运行结束 **/";

                logText.append(curProgressData.log);
                logText.append("\n");

                publish(curProgressData);

                progressBar.setValue(Integer.parseInt(RunFuck.RunTime));
            }catch (JSONException e){
                curProgressData=new ProgressData();
                curProgressData.curSecond=0x3fffffff;
                curProgressData.log="\n/** 错误发生前全部的信息 **/\n"+logText.toString()+WorkingFrame.lastErrorResponse+"\n";
                logText.append(curProgressData.log);
                publish(curProgressData);

                return logText;
                //e.printStackTrace();
            }

            return logText;
        }

        public void process(List<ProgressData> progressList){
            var builder=new StringBuilder();
            for(ProgressData d:progressList){
                builder.append(d.log);
            }
            logTextArea.append(builder.toString());
        }

        public void done(){
            StringBuilder result= null;
            completed=true;
            System.out.println("Runtime="+RunFuck.RunTime);
            try {
                result = get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            logTextArea.setText(result.toString());
        }

    }

}
