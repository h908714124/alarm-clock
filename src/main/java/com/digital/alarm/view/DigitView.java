package com.digital.alarm.view;

import javax.swing.JPanel;
import java.awt.Color;

class DigitView extends JPanel {

    static JPanel create() {
        JPanel frame = new DigitView();
        frame.setBackground(Color.DARK_GRAY);
        frame.setSize(ViewUtil.width(100));
        frame.setMinimumSize(ViewUtil.width(100));
        frame.setPreferredSize(ViewUtil.width(100));
        return frame;
    }

}
