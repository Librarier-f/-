import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Vector;

public class JtableDemo extends JFrame{
    public JtableDemo() {
        super("JtableDemo");

        Vector<Vector<Object>> data = new Vector<>();

        Vector<Object> row = new Vector<>();
        row.addElement("1");
        row.addElement("张三");
        row.addElement("123456");
        row.addElement("北京");
        row.addElement("90");
        row.addElement("80");
        row.addElement("70");
        row.addElement("240");

        // 添加第二个学生的信息
        Vector<Object> row2 = new Vector<>();
        row2.addElement("2");
        row2.addElement("李四");
        row2.addElement("654321");
        row2.addElement("上海");
        row2.addElement("85");
        row2.addElement("90");
        row2.addElement("80");
        row2.addElement("255");

        // 添加第三个学生的信息
        Vector<Object> row3 = new Vector<>();
        row3.addElement("3");
        row3.addElement("王五");
        row3.addElement("987654");
        row3.addElement("广州");
        row3.addElement("75");
        row3.addElement("85");
        row3.addElement("90");
        row3.addElement("250");

        data.addElement(row);
        data.addElement(row2);
        data.addElement(row3);

        //tablemodel:和jtable关联后，jtable的数据就会变化，之后只需要通过tablemodel来操作jtable的数据
        // 把数据放到tablemodel中
        StudentTablemodel studentTablemodel = StudentTablemodel.assembleModel(data);
        JTable jTable = new JTable(studentTablemodel);

        //设置表头
        JTableHeader jTableHeader = jTable.getTableHeader();
        jTableHeader.setFont(new Font(null, Font.BOLD, 16));
        jTableHeader.setForeground(Color.RED);

        //设置表格体
        jTable.setFont(new Font(null, Font.PLAIN, 14));
        //设置行高
        jTable.setRowHeight(30);
        //设置背景色
        jTable.setForeground(Color.black);
        //设置网格线
        jTable.setGridColor(Color.BLACK);
        //设置多行选择
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //设置每列的渲染方式
        Vector<String> columns = StudentTablemodel.getColumn();
        StudentCellRender render = new StudentCellRender();
        for (int i = 0; i < columns.size(); i++) {
            // 把列名放到表头中
            TableColumn column = jTable.getColumn(columns.get(i));
            column.setCellRenderer(render);
            if (i == 0) {
                column.setPreferredWidth(50);
                column.setMaxWidth(50);
                column.setResizable(false);
            }

        }


        Container contentPane = getContentPane();
        //jtable放在jpanel上的话，jtable会显示不全（不展示列头），所以需要用滚动面板来包裹jtable
        JScrollPane jScrollPane = new JScrollPane(jTable);
        contentPane.add(jScrollPane, BorderLayout.CENTER);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //创建表格
    }
    public static void main(String[] args) {
        new JtableDemo();
    }
}

// 自定义渲染器
class StudentCellRender extends DefaultTableCellRenderer {
    // 在每一行的每一个单元格上渲染数据
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}

class StudentTablemodel extends DefaultTableModel {

    // 表格列名
    static Vector<String> columns = new Vector<>();

    //设置表格不可编辑
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    // 表格数据
    static {
        columns.addElement("编号");
        columns.addElement("姓名");
        columns.addElement("学号");
        columns.addElement("籍贯");
        columns.addElement("语文");
        columns.addElement("数学");
        columns.addElement("英语");
        columns.addElement("总分");
    }

    // 私有化构造方法，保证只能通过assembleModel方法来创建对象
    private StudentTablemodel() {
        super(null, columns);
    }

    private static StudentTablemodel studentTablemodel = new StudentTablemodel();

    // 组装表格数据的方法
    public static StudentTablemodel assembleModel(Vector<Vector<Object>> data) {
        studentTablemodel.setDataVector(data, columns);
        return studentTablemodel;
    }

    // 提供获取表格列名的方法
    public static Vector<String> getColumn() {
        return columns;
    }
}
