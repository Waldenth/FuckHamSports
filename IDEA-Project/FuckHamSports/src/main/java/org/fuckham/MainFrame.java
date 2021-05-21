/*
 * Created by JFormDesigner on Fri Mar 26 22:46:49 CST 2021
 */

package org.fuckham;




import org.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author dasd
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    private void initConfiguration() throws Exception{

        File file=new File("fuckham.conf");
        String configurationStr=null;
        if(file.exists()){
            try(FileInputStream fis=new FileInputStream(file)){
                StringBuilder buffer=new StringBuilder();
                InputStreamReader ipr = new InputStreamReader(fis, "utf-8");
                BufferedReader reader = new BufferedReader(ipr);
                String tempStr;
                while ((tempStr = reader.readLine()) != null) {
                    buffer.append(tempStr);
                }
                reader.close();
                configurationStr=buffer.toString();
            }catch (IOException e){
                JOptionPane.showMessageDialog(null, "读取配置文件失败", "错误", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            JSONObject configureJSONObject=new JSONObject(configurationStr);
            Configure configure=Configure.getConfigureObject(configureJSONObject);
            //System.out.println(configure.imeiCode);
            //System.out.println(configure.needSleep);
            //System.out.println(configure.coordinate.longitude);
            //System.out.println(configure.coordinate.latitude);
            imeiCodeFileld.setText(configure.imeiCode);
            versionComboBox.setSelectedIndex(configure.versionIndex);
            timeField.setText(configure.runtime);
            stepField.setText(configure.step);
            longitudeField.setText(configure.coordinate.longitude);
            latitudeField.setText(configure.coordinate.latitude);
            yesButton.setSelected(configure.needSleep);
            noButton.setSelected(!configure.needSleep);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        titleLabel = new JLabel();
        imeiCodeTip = new JLabel();
        imeiCodeFileld = new JTextField();
        versionTip = new JLabel();
        versionComboBox = new JComboBox<>();
        startButton = new JButton();
        timeTip = new JLabel();
        timeField = new JTextField();
        stepTip = new JLabel();
        stepField = new JTextField();
        coordinatesTip = new JLabel();
        longitudeField = new JTextField();
        latitudeField = new JTextField();
        needSleepTips = new JLabel();
        yesButton = new JRadioButton();
        noButton = new JRadioButton();
        saveConfigureButton = new JButton();

        //======== this ========
        setTitle("FuckHam");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/ico.jpg")).getImage());
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 102));

            //---- titleLabel ----
            titleLabel.setText("   FuckHam");
            titleLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
            titleLabel.setForeground(Color.white);

            //---- imeiCodeTip ----
            imeiCodeTip.setText("\u8bf7\u8f93\u5165IMEI\u7801");
            imeiCodeTip.setForeground(Color.white);
            imeiCodeTip.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- imeiCodeFileld ----
            imeiCodeFileld.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            imeiCodeFileld.setForeground(Color.black);
            imeiCodeFileld.setBackground(Color.white);

            //---- versionTip ----
            versionTip.setText("\u9009\u62e9\u7248\u672c");
            versionTip.setForeground(Color.white);
            versionTip.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- versionComboBox ----
            versionComboBox.setBackground(Color.darkGray);
            versionComboBox.setForeground(Color.white);
            versionComboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            versionComboBox.setEditable(true);
            versionComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "2.40"
            }));

            //---- startButton ----
            startButton.setText("Start");
            startButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            startButton.setBackground(Color.darkGray);
            startButton.setForeground(Color.white);

            //---- timeTip ----
            timeTip.setText("\u8bf7\u8f93\u5165\u8dd1\u6b65\u65f6\u95f4(s)");
            timeTip.setForeground(Color.white);
            timeTip.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- timeField ----
            timeField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            timeField.setForeground(Color.white);
            timeField.setBackground(Color.darkGray);
            timeField.setText("600");

            //---- stepTip ----
            stepTip.setText("\u8bf7\u8f93\u5165\u5927\u81f4\u6b65\u6570");
            stepTip.setForeground(Color.white);
            stepTip.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- stepField ----
            stepField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            stepField.setForeground(Color.white);
            stepField.setBackground(Color.darkGray);
            stepField.setText("1500");

            //---- coordinatesTip ----
            coordinatesTip.setText("\u786e\u5b9a\u7ecf\u7eac\u5ea6");
            coordinatesTip.setForeground(Color.white);
            coordinatesTip.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- longitudeField ----
            longitudeField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            longitudeField.setForeground(Color.black);
            longitudeField.setBackground(Color.white);
            longitudeField.setText("114.367788");

            //---- latitudeField ----
            latitudeField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
            latitudeField.setForeground(Color.black);
            latitudeField.setBackground(Color.white);
            latitudeField.setText("30.534736");

            //---- needSleepTips ----
            needSleepTips.setText("\u6a21\u62df\u4f11\u7720");
            needSleepTips.setForeground(Color.white);
            needSleepTips.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- yesButton ----
            yesButton.setText("\u662f");
            yesButton.setBackground(new Color(102, 102, 102));
            yesButton.setForeground(Color.white);
            yesButton.setSelected(true);

            //---- noButton ----
            noButton.setText("\u5426");
            noButton.setBackground(new Color(102, 102, 102));
            noButton.setForeground(Color.white);

            //---- saveConfigureButton ----
            saveConfigureButton.setText("\u4fdd\u5b58\u914d\u7f6e");
            saveConfigureButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));
            saveConfigureButton.setBackground(Color.darkGray);
            saveConfigureButton.setForeground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(imeiCodeTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imeiCodeFileld, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(versionComboBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                        .addComponent(versionTip, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(coordinatesTip, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(longitudeField, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(saveConfigureButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(latitudeField, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(timeField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stepTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stepField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(needSleepTips)
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(noButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yesButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))))
                        .addGap(29, 29, 29))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(257, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(imeiCodeTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(imeiCodeFileld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(versionTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stepTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(timeTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(stepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(needSleepTips, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yesButton))
                                .addGap(18, 18, 18)
                                .addComponent(noButton)
                                .addContainerGap(102, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(versionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(coordinatesTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(longitudeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(latitudeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveConfigureButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
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

        //---- sleepButtonGroup ----
        var sleepButtonGroup = new ButtonGroup();
        sleepButtonGroup.add(yesButton);
        sleepButtonGroup.add(noButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        try {
            initConfiguration();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "载入设置文件失败\n请检查文件是否找到更改或删除文件\n即将以默认配置运行.", "错误", JOptionPane.ERROR_MESSAGE);
        }

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(imeiCodeFileld.getText());
                //System.out.println(versionComboBox.getSelectedItem().toString());
                //System.out.println(timeField.getText());
                //System.out.println(stepField.getText());
                String imeiCode=imeiCodeFileld.getText().replaceAll("\\s*","");
                String version=versionComboBox.getSelectedItem().toString().replaceAll("\\s*","");
                String time=timeField.getText().replaceAll("\\s*","");
                String step=stepField.getText().replaceAll("\\s*","");
                String longtitude=longitudeField.getText().replaceAll("\\s*","");
                String latitude=latitudeField.getText().replaceAll("\\s*","");
                int confirmed=JOptionPane.showConfirmDialog(null,"Your IMEI:"+imeiCode+"\n"
                        +"Your version:"+version+"\n"
                        +"Approximate time:"+time+"(s)\n"
                        +"Approximate steps:"+step+"\n"
                        +"Longtitude:"+longtitude+"\n"
                        +"Latitude:"+latitude,"确认",JOptionPane.YES_NO_OPTION);
                //System.out.println(confirmed);
                if(confirmed==0){
                    if(imeiCode.length()!=32){
                        JOptionPane.showMessageDialog(null, "IMEI码长度应为32", "错误",JOptionPane.ERROR_MESSAGE);
                    }else {
                        boolean needSleep=true;
                        if(noButton.isSelected()){
                            JOptionPane.showMessageDialog(null, "你选择了不进行休眠模拟\n这样可能导致服务器端请求时间异常.", "警告",JOptionPane.WARNING_MESSAGE);
                            needSleep=false;
                        }
                        MainFrame.this.setEnabled(false);
                        MainFrame thisMainFrame=MainFrame.this;
                        WorkingFrame workingFrame = new WorkingFrame(thisMainFrame,imeiCode, version, time, step,longtitude,latitude,needSleep);
                        workingFrame.setVisible(true);
                    }
                }
            }
        });

        saveConfigureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imeiCode=imeiCodeFileld.getText().replaceAll("\\s*","");
                int versionIndex=versionComboBox.getSelectedIndex();
                String version=versionComboBox.getSelectedItem().toString().replaceAll("\\s*","");
                String time=timeField.getText().replaceAll("\\s*","");
                String step=stepField.getText().replaceAll("\\s*","");
                String longtitude=longitudeField.getText().replaceAll("\\s*","");
                String latitude=latitudeField.getText().replaceAll("\\s*","");
                boolean needSleep=noButton.isSelected()?false:true;

                int confirmed=JOptionPane.showConfirmDialog(null,"请确认导出配置:\nYour IMEI:"+imeiCode+"\n"
                        +"Your version:"+version+"\n"
                        +"Approximate time:"+time+"(s)\n"
                        +"Approximate steps:"+step+"\n"
                        +"Longtitude:"+longtitude+"\n"
                        +"Latitude:"+latitude+"\n"
                        +"needSleep:"+needSleep,"确认",JOptionPane.YES_NO_OPTION);
                if(confirmed==0){
                    //Configure userCongiure=new Configure(imeiCode,version,new Coordinate(longtitude,latitude),time,step,needSleep);
                    //com.alibaba.fastjson.JSONObject configureJSONObject= new com.alibaba.fastjson.JSONObject((Map<String, Object>) userCongiure);
                    //System.out.println(configureJSONObject);
                    JSONObject configureJSONObject=Configure.toJSONObject(imeiCode,versionIndex,new Coordinate(longtitude,latitude),time,step,needSleep);
                    File file=new File("fuckham.conf");
                    FileOutputStream output=null;
                    try {
                        output = new FileOutputStream(file);
                        OutputStreamWriter writer = new OutputStreamWriter(output, "utf-8");
                        writer.write(configureJSONObject.toString());
                        writer.flush();
                        JOptionPane.showMessageDialog(null, "导出配置成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        JOptionPane.showMessageDialog(null, "导出配置失败", "错误", JOptionPane.ERROR_MESSAGE);
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
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel titleLabel;
    private JLabel imeiCodeTip;
    private JTextField imeiCodeFileld;
    private JLabel versionTip;
    private JComboBox<String> versionComboBox;
    private JButton startButton;
    private JLabel timeTip;
    private JTextField timeField;
    private JLabel stepTip;
    private JTextField stepField;
    private JLabel coordinatesTip;
    private JTextField longitudeField;
    private JTextField latitudeField;
    private JLabel needSleepTips;
    private JRadioButton yesButton;
    private JRadioButton noButton;
    private JButton saveConfigureButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
