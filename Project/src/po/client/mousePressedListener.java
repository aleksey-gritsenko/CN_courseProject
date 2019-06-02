package po.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mousePressedListener implements MouseListener {
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        Point location = MouseInfo.getPointerInfo().getLocation();
        int x =(int) location.getX();
        int y =(int) location.getY();
        System.out.println("x = " + x+"!!");
        System.out.println("y = " + y+"!!");
    }

    public void mouseReleased(MouseEvent e) {
    }
}

