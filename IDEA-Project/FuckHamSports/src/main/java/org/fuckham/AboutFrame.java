/*
 * Created by JFormDesigner on Sat Mar 27 08:43:21 CST 2021
 */

package org.fuckham;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author dasd
 */
public class AboutFrame extends JFrame {
    public AboutFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label3 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setTitle("About");
        setIconImage(new ImageIcon(getClass().getResource("/ico.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.darkGray);

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/github.png")));

            //---- label2 ----
            label2.setText("https://github.com/Waldenth");
            label2.setForeground(Color.white);
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- label4 ----
            label4.setText("<html>\u53c2\u8003\u9879\u76ee:/S-Ex1t/SunnyRunningPy<br>\u611f\u8c22@S-Ex1t\u7684\u9006\u5411\u5de5\u4f5c\u63d0\u4f9b\u7684\u601d\u8def</html>");
            label4.setForeground(Color.white);
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- label5 ----
            label5.setText("\u672c\u9879\u76ee\u9075\u5b88GPL3.0\u534f\u8bae-\u5b8c\u5168\u514d\u8d39");
            label5.setForeground(Color.white);
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- label6 ----
            label6.setText("\u8d4f\u5305\u8fa3\u6761 Ciallo\uff5e(\u2220\u30fb\u03c9< )\u2312\u2606");
            label6.setForeground(Color.white);
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

            //---- label7 ----
            label7.setIcon(new ImageIcon(getClass().getResource("/alipay.jpg")));

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/wechatpay.png")));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label7)))
                        .addGap(37, 37, 37))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))))
                        .addGap(53, 53, 53))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(label7))
                        .addGap(22, 22, 22))
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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label3;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
