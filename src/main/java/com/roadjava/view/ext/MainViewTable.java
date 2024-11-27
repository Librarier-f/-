package com.roadjava.view.ext;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class MainViewTable extends JTable {
    public MainViewTable() {
        //设置表头
        JTableHeader jTableHeader = getTableHeader();
        jTableHeader.setFont(new Font(null, Font.BOLD, 16));
        jTableHeader.setForeground(Color.RED);

        //设置表格体
        setFont(new Font(null, Font.PLAIN, 14));
        //设置行高
        setRowHeight(30);
        //设置背景色
        setForeground(Color.black);
        //设置网格线
        setGridColor(Color.BLACK);
        //设置多行选择
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
}
