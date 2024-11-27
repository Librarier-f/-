package learnSwing;

import javax.swing.*;
import java.awt.*;

public class SpringLayoutTest extends JFrame {

    //设置jpanel的布局管理器为springLayout
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JLabel titleLabel = new JLabel("文章标题");
    JTextField titletxt = new JTextField();
    JLabel authorLabel = new JLabel("作者");
    JTextField authorTxt = new JTextField();
    JLabel contLabel = new JLabel("请输入内容");
    JTextArea contArea = new JTextArea(4, 10);

    public SpringLayoutTest(){
        super("弹簧布局SpringLayout");

        Container contentPane = getContentPane();

        jPanel.add(titleLabel);
        titletxt.setPreferredSize(new Dimension(200,30));
        jPanel.add(titletxt);
        jPanel.add(authorLabel);
        authorTxt.setPreferredSize(new Dimension(200, 30));
        jPanel.add(authorTxt);
        jPanel.add(contLabel);
        jPanel.add(contArea);

        jPanel.setBackground(Color.ORANGE);

        /*
            springLayout : 布局管理器
            SpringLayout.Constraint: 使用弹簧布局的容器里面的组件的布局约束，每个组件对应一个
            Spring : 可以理解为一个能够进行四则运算的整数
         */
        Spring titleLabelWidth = Spring.width(titleLabel);
        Spring titleTxtWidth = Spring.width(titletxt);
        Spring spaceWidth = Spring.constant(20);
        Spring childWidth = Spring.sum(Spring.sum(titleLabelWidth, titleTxtWidth), spaceWidth);
        int offsetX = childWidth.getValue() / 2;

        SpringLayout.Constraints titleLabelC = springLayout.getConstraints(titleLabel);
//        titleLabelC.setX(Spring.constant(100));
        springLayout.putConstraint(SpringLayout.WEST, titleLabel, -offsetX, SpringLayout.HORIZONTAL_CENTER, jPanel);
        titleLabelC.setY(Spring.constant(50));

        /*
            设置约束的第一种写法，比较复杂
         */
//        设置标题文本框：titleTxt西边边距离titleLabel的东边20px,北边相同
//        获取标题文本框的布局约束
        SpringLayout.Constraints titleTxtC = springLayout.getConstraints(titletxt);
//        edgeName:东南西北   s:值
//        获取标题标签的右侧位置（EAST）的弹簧值，设置标题文本框的左侧（WEST）位置为标题标签右侧位置加上 20px 的间距
//        并将标题文本框的顶部（NORTH）位置与标题标签顶部对齐
        Spring titleLabelEastSpring = titleLabelC.getConstraint(SpringLayout.EAST);
        titleTxtC.setConstraint(SpringLayout.WEST, Spring.sum(titleLabelEastSpring, Spring.constant(20)));
        titleTxtC.setConstraint(SpringLayout.NORTH, titleLabelC.getConstraint(SpringLayout.NORTH));


        /*
            设置约束的第二种写法
            e1:要设置组件的哪个边界
            c1:要设置的组件
            pad:距离值
            e2:参照组件的边界名
            c2:参照物(组件)
         */
        //设置作者label : authorLabel 东边和titleLabel对齐，北边距离titleLabel南边40px
        springLayout.putConstraint(SpringLayout.EAST, authorLabel, 0, SpringLayout.EAST, titleLabel);
        springLayout.putConstraint(SpringLayout.NORTH, authorLabel, 40, SpringLayout.NORTH, titleLabel);

        //设置authorTxt:authorTxt西边距离authorLabel的东边20px,北边相同
        springLayout.putConstraint(SpringLayout.WEST, authorTxt, 20, SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,authorTxt,0, SpringLayout.NORTH, authorLabel);

        //contLabel
        springLayout.putConstraint(SpringLayout.EAST, contLabel, 0, SpringLayout.EAST,authorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,contLabel,40, SpringLayout.NORTH, authorLabel);

        //contArea
        springLayout.putConstraint(SpringLayout.WEST, contArea, 20, SpringLayout.EAST,contLabel);
        springLayout.putConstraint(SpringLayout.NORTH, contArea, 0, SpringLayout.NORTH,contLabel);

        //contArea的南边和东边参照jPanel,达到相应式变化大小
        springLayout.putConstraint(SpringLayout.SOUTH, contArea, -20, SpringLayout.SOUTH, jPanel);
        springLayout.putConstraint(SpringLayout.EAST, contArea, -20, SpringLayout.EAST, jPanel);

        contentPane.add(jPanel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SpringLayoutTest();
    }
}
