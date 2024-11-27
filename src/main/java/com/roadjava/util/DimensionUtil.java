package com.roadjava.util;

import javax.swing.*;
import java.awt.*;

public class DimensionUtil {
    public static Dimension getBounds(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //保证界面不会覆盖电脑屏幕的任务栏
        Insets screenInsets = Toolkit.getDefaultToolkit().
                getScreenInsets(new JFrame().getGraphicsConfiguration());

        return screenSize;
    }
}
