package po.client;
import javax.swing.JComponent;
import java.awt.*;

// TODO use JTable + DefaultTableModel here
public class Field extends JComponent {
    public void paint(Graphics g) {
        g.drawRect(10, 10, 800, 500);
        for( int i=10; i<= 800; i+=10)
            g.drawLine (i, 10, i, 510);

        for(int i= 10; i<= 500; i+=10)
            g.drawLine (10, i, 810, i);
    }
}
