/*
 * Created by JFormDesigner on Fri Mar 26 22:46:49 CST 2021
 */

package org.fuckham;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author dasd
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(imeiCodeTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imeiCodeFileld, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(versionComboBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                        .addComponent(versionTip, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(timeField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stepTip, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stepField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(imeiCodeTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(imeiCodeFileld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(versionTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(stepTip, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(versionComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(stepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
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


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(imeiCodeFileld.getText());
                //System.out.println(versionComboBox.getSelectedItem().toString());
                //System.out.println(timeField.getText());
                //System.out.println(stepField.getText());
                int confirmed=JOptionPane.showConfirmDialog(null,"Your IMEI:"+imeiCodeFileld.getText()+"\n"
                +"Your version:"+versionComboBox.getSelectedItem().toString()+"\n"+"Approximate time:"+timeField.getText()+"(s)\n"
                        +"Approximate steps:"+stepField.getText(),"确认",JOptionPane.YES_NO_OPTION);
                //System.out.println(confirmed);
                if(confirmed==0){
                    WorkingFrame workingFrame= new WorkingFrame(imeiCodeFileld.getText(),versionComboBox.getSelectedItem().toString(),timeField.getText(),stepField.getText());
                    workingFrame.setVisible(true);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
