package com.roadjava.handler;

import com.roadjava.view.LoginView;
import com.roadjava.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginHandler extends KeyAdapter implements ActionListener  {

    private LoginView loginView;
    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 得到触发事件的按钮
        JButton Jbutton = (JButton) e.getSource();
        // 得到按钮上的文字
        String text = Jbutton.getText();
        // 比较按钮上的文字，判断是哪个按钮被点击了
        if ("重置".equals(text)) {
            // 清空文本框
            loginView.getUserTxt().setText("");
            loginView.getPwdField().setText("");
        }else if ("登录".equals(text)) {
            login();
        }
    }

    private void login() {
        String user = loginView.getUserTxt().getText();
        char[] chars = loginView.getPwdField().getPassword();
        String pwd = new String(chars);
        System.out.println(user + ":" + pwd);
        //查询db
        boolean flag = true;
        if (flag) {
            //跳转到主界面并销毁登录界面
            loginView.dispose();
            new MainView();
        }else {
            JOptionPane.showMessageDialog(loginView, "用户名或密码错误");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        e.getKeyCode();
        // 按下回车键
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }
}
