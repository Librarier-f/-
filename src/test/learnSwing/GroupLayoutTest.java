package learnSwing;

import javax.swing.*;

public class GroupLayoutTest extends JFrame {

    public GroupLayoutTest() {
        super("弹簧布局简化版 - GroupLayout");

        // 创建标签和输入框
        JLabel titleLabel = new JLabel("文章标题");
        JTextField titleTxt = new JTextField(20); // 设置列宽为20
        JLabel authorLabel = new JLabel("作者");
        JTextField authorTxt = new JTextField(20);
        JLabel contLabel = new JLabel("请输入内容");
        JTextArea contArea = new JTextArea(4, 20);

        // 包裹内容的滚动面板
        JScrollPane contScrollPane = new JScrollPane(contArea);

        // 设置布局管理器
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true); // 自动创建组件间的间距
        layout.setAutoCreateContainerGaps(true); // 自动创建容器边距

        // 设置水平和垂直的布局组
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(titleLabel)
                                .addComponent(authorLabel)
                                .addComponent(contLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titleTxt)
                                .addComponent(authorTxt)
                                .addComponent(contScrollPane))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(titleLabel)
                                .addComponent(titleTxt))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(authorLabel)
                                .addComponent(authorTxt))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(contLabel)
                                .addComponent(contScrollPane))
        );

        // 设置窗口属性
        getContentPane().add(panel);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GroupLayoutTest();
    }
}
