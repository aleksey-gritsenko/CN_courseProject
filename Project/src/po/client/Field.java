package po.client;
import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


// TODO use JTable + DefaultTableModel here
public class Field extends JComponent {

    private List<Point> fillCells;

    public Field() {
        fillCells = new ArrayList<>(25);
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, 1000, 1000);
        for (int i = 0; i <= 1000; i += 100)
            g.drawLine(i, 0, i, 1000);

        for (int i = 0; i <= 1000; i += 100)
            g.drawLine(0, i, 1000, i);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point fillCell : fillCells) {
            int cellX = (fillCell.x * 100);
            int cellY = (fillCell.y * 100);
            g.setColor(Color.blue);
            g.fillRect(cellX, cellY, 10, 10);
        }


    }
    public void fillCell ( int x, int y){
        fillCells.add(new Point(x, y));
        repaint();
    }

    }

