package com.roadjava.view;

import com.roadjava.util.DimensionUtil;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainView extends JFrame {
    JPanel northPanel = new JPanel();
    JButton addBtn = new JButton("添加");
    JButton deleteBtn = new JButton("删除");
    JButton updateBtn = new JButton("修改");
    JTextField searchTxt = new JTextField(15);
    JButton searchBtn = new JButton("查询");

    JPanel southPanel = new JPanel();
    JButton preBtn = new JButton("上一页");
    JButton nextBtn = new JButton("下一页");



    public MainView(){
        super("学生成绩管理系统主界面");
        Container contentPane = getContentPane();

        layoutNorth(contentPane);
        layoutSouth(contentPane);

        URL imgUrl = MainView.class.getClassLoader().getResource("test.png");
        setIconImage(new ImageIcon(imgUrl).getImage());

        //根据屏幕大小设置主界面大小
        setSize(DimensionUtil.getBounds());

        //设置窗体完全充满整个屏幕的可见大小
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }

    private void layoutSouth(Container contentPane) {
        southPanel.add(preBtn);
        southPanel.add(nextBtn);
        // 把面板加入到主界面中
        contentPane.add(southPanel, BorderLayout.SOUTH);
    }

    private void layoutNorth(Container contentPane) {
        northPanel.add(addBtn);
        northPanel.add(deleteBtn);
        northPanel.add(updateBtn);
        northPanel.add(searchTxt);
        northPanel.add(searchBtn);
        // 把面板加入到主界面中
        contentPane.add(northPanel, BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        new MainView();
    }




}
