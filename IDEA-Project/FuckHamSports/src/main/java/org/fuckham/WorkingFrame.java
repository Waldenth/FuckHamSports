/*
 * Created by JFormDesigner on Sat Mar 27 08:36:22 CST 2021
 */

package org.fuckham;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author dasd
 */
public class WorkingFrame extends JFrame {
    public WorkingFrame(String imeiCode,String version,String seconds,String steps) {
        this.imeiCode=imeiCode;
        this.version=version;
        this.seconds=Integer.valueOf(seconds);
        this.steps=Integer.valueOf(steps);
        initComponents();
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
                        .addGap(74, 74, 74)
                        .addComponent(exportLogButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(aboutInfoButton)
                        .addGap(76, 76, 76))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
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
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                    jfc.showDialog(new JLabel(), "选择");
                    File file=jfc.getSelectedFile();
                    if(!file.isFile()){
                        try {
                            file.createNewFile();
                        } catch (IOException ioException) {
                            JOptionPane.showMessageDialog(null, "创建文件失败", "错误",JOptionPane.ERROR_MESSAGE);
                            ioException.printStackTrace();
                        }
                    }
                    if(file.isFile()){
                        String log=logText.toString();
                        try {
                            FileOutputStream output=new FileOutputStream(file);
                            OutputStreamWriter writer=new OutputStreamWriter(output,"utf-8");
                            writer.write(log);
                            writer.flush();
                            JOptionPane.showMessageDialog(null,"导出日志成功","提示",JOptionPane.PLAIN_MESSAGE);
                        } catch (IOException ioException) {
                            JOptionPane.showMessageDialog(null, "写入文件失败", "错误",JOptionPane.ERROR_MESSAGE);
                            ioException.printStackTrace();
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
    private StringBuilder logText = new StringBuilder();
    private String imeiCode;
    private String version;
    private int seconds;
    private int steps;
    private boolean completed=false;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private class ProgressData{
        private int curSecond;
        private String log;
    }


    public class RunFucker extends SwingWorker<StringBuilder,ProgressData> {


        //private StringBuilder logText = new StringBuilder();

        public RunFucker(){

        }

        public StringBuilder doInBackground() throws IOException,InterruptedException {
            RunFuck.randomAlphabet();

            logText.append(RunFuck.login(imeiCode,version));
            logText.append("\n");

            //System.out.println(logText.toString());


            logText.append(RunFuck.getUserInfo());
            logText.append("\n");

            logText.append(RunFuck.getRunInfo(seconds,steps));
            logText.append("\n");


            progressBar.setMinimum(0);
            progressBar.setMaximum(Integer.valueOf(RunFuck.RunTime));
            progressBar.setStringPainted(true);

            var curProgressData=new ProgressData();
            curProgressData.curSecond=0;
            curProgressData.log=logText.toString();
            publish(curProgressData);

            for(int i=1;i<Integer.valueOf(RunFuck.RunTime);i++){
                Thread.sleep(1000);
                curProgressData=new ProgressData();
                curProgressData.curSecond=i;
                curProgressData.log="";
                publish(curProgressData);
                progressBar.setValue(i);
            }


            curProgressData=new ProgressData();
            curProgressData.curSecond=Integer.valueOf(RunFuck.RunTime);
            curProgressData.log=RunFuck.getEndRunningInfo();

            logText.append(curProgressData.log);
            logText.append("\n");

            progressBar.setValue(Integer.valueOf(RunFuck.RunTime));

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
            try {
                result = get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            logTextArea.setText(result.toString());
        }

    }

}
