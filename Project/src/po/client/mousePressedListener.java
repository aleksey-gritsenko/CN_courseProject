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
    public static String toString (int i){
        String numberAsString = Integer.toString (i);
        return numberAsString;
    }
    public String Response(MouseEvent e){
        Point location = MouseInfo.getPointerInfo().getLocation();
        int x =(int) location.getX();
        int y =(int) location.getY();
        String response = toString(x) + "." + toString(y);
        return  response;

    }

    public void mouseReleased(MouseEvent e) {
    }
}

