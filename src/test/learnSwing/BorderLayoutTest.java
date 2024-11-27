package learnSwing;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame{
    JButton northBtn = new JButton("北边的按钮");
    JLabel southLabel = new JLabel("南边的按钮");
    JRadioButton westRadioBtn = new JRadioButton("男");
    JTextArea eastArea = new JTextArea("输入内容", 10, 20);
    JButton centerBtn = new JButton("中间的按钮");


    public BorderLayoutTest(){

        //尽可能充满整个容器

        super("测试边界布局");

        Container containerPane = getContentPane();
        // 设置布局管理器
        containerPane.setLayout(new BorderLayout());
        containerPane.add(northBtn, BorderLayout.NORTH);
        containerPane.add(westRadioBtn, BorderLayout.WEST);
        //0表示默认
        westRadioBtn.setPreferredSize(new Dimension(200, 0));
        containerPane.add(eastArea, BorderLayout.EAST);
        containerPane.add(southLabel, BorderLayout.SOUTH);
        southLabel.setPreferredSize(new Dimension(0, 80));
        containerPane.add(centerBtn, BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
      new BorderLayoutTest();
    }
}
