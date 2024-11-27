package learnSwing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JframeTest extends JFrame{
    JFrame jFrame;
    JButton jButton;

    public JframeTest(){
        //容器组件：Jframe,jpanel,jscrollpane
        jFrame = new JFrame("标题");

        jButton = new JButton("这是一个按钮");
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jButton);

        //设置窗体图标
        URL resource = JframeTest.class.getClassLoader().getResource("test.png");
        Image image = new ImageIcon(resource).getImage();
        jFrame.setIconImage(image);
        jFrame.setSize(600, 400);

        //居中
        //jFrame.setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int offsetX = (screenSize.width - 600)/2;
        int offsetY = (screenSize.height - 400) / 2;
        jFrame.setLocation(offsetX, offsetY);

        //关闭时退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可改变
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
      new JframeTest();
    }
}
