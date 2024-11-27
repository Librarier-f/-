package com.roadjava.view;

import com.roadjava.handler.LoginHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class LoginView extends JFrame {
    JLabel nameLabel = new JLabel("学生成绩管理系统", JLabel.CENTER);

    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);
    JLabel usernameLabel = new JLabel("用户名");
    JTextField userTxt = new JTextField();
    JLabel pwdLabel = new JLabel("密码");
    JPasswordField pwdField = new JPasswordField();
    JButton loginBtn = new JButton("登录");
    JButton resetBtn = new JButton("重置");

    SystemTray systemTray;
    TrayIcon trayIcon;
    // 登录处理类的实例
    LoginHandler loginHandler ;
    public LoginView(){
        super("学生成绩管理系统");

        loginHandler = new LoginHandler(this);

        Container contentPane = getContentPane();

        //设置字体
        nameLabel.setFont(new Font("华文行楷", Font.PLAIN, 40));
        nameLabel.setPreferredSize(new Dimension(0, 80));

        //设置字体大小
        Font centerFont = new Font("楷体", Font.PLAIN, 20);
        usernameLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginBtn.setFont(centerFont);
        resetBtn.setFont(centerFont);

        //设置文本输入框大小
        userTxt.setPreferredSize(new Dimension(200, 30));
        pwdField.setPreferredSize(new Dimension(200, 30));

        //把组件加入面板
        centerPanel.add(usernameLabel);
        centerPanel.add(userTxt);
        centerPanel.add(pwdLabel);
        centerPanel.add(pwdField);
        centerPanel.add(loginBtn);
        loginBtn.addActionListener(loginHandler);
        centerPanel.add(resetBtn);
        resetBtn.addActionListener(loginHandler);
        loginBtn.addKeyListener(loginHandler);

        // 弹簧布局
        extracted();

        contentPane.add(nameLabel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);

        if(SystemTray.isSupported()) {
            systemTray = SystemTray.getSystemTray();
            URL imgUrl = LoginView.class.getClassLoader().getResource("test.png");
            if (imgUrl != null) {
                trayIcon = new TrayIcon(new ImageIcon(imgUrl).getImage());
                //设置托盘图片大小自动缩放
                trayIcon.setImageAutoSize(true);
            }
            try {
                systemTray.add(trayIcon);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }

            //增加最小化时销毁资源
//            this.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowIconified(WindowEvent e) {
//                    //最小化时任务栏窗口消失
//                    LoginView.this.dispose();
//                }
//            });
            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int clickCount = e.getClickCount();
                    if(clickCount == 1) {
                        LoginView.this.setExtendedState(JFrame.NORMAL);
                    }
                    LoginView.this.setVisible(true);
                }
            });
        }

        //设置loginBtn的默认按钮
        this.getRootPane().setDefaultButton(loginBtn);


        URL imgUrl = LoginView.class.getClassLoader().getResource("test.png");
        setIconImage(new ImageIcon(imgUrl).getImage());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void extracted() {
        //弹簧布局
        //布局userNameLabel
        Spring childWidth = Spring.sum(Spring.sum(Spring.width(usernameLabel), Spring.width(userTxt)),
                Spring.constant(20));
        int offsetX = childWidth.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, usernameLabel, -offsetX,
                SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 20, SpringLayout.NORTH,centerPanel);

        //布局userTxt
        springLayout.putConstraint(SpringLayout.WEST,userTxt,20, SpringLayout.EAST, usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, userTxt, 0, SpringLayout.NORTH, usernameLabel);

        //pwdLabel
        springLayout.putConstraint(SpringLayout.EAST,pwdLabel,0, SpringLayout.EAST, usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdLabel, 20, SpringLayout.SOUTH, usernameLabel);

        //pwdTxt
        springLayout.putConstraint(SpringLayout.WEST, pwdField,20, SpringLayout.EAST, pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdField, 0, SpringLayout.NORTH, pwdLabel);

        //loginBtn
        springLayout.putConstraint(SpringLayout.WEST, loginBtn, 40, SpringLayout.WEST, pwdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, loginBtn, 30, SpringLayout.SOUTH, pwdLabel);

        //resetBtn
        springLayout.putConstraint(SpringLayout.WEST, resetBtn, 40, SpringLayout.EAST, loginBtn);
        springLayout.putConstraint(SpringLayout.NORTH, resetBtn, 0, SpringLayout.NORTH, loginBtn);
    }

    public static void main(String[] args) {
        new LoginView();
    }

    public JTextField getUserTxt() {
        return userTxt;
    }

    public void setUserTxt(JTextField userTxt) {
        this.userTxt = userTxt;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }


}
