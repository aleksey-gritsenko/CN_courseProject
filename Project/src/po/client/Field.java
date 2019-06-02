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
    public Integer[][] Parse(String request){
        StringBuilder tmp = new StringBuilder(request);
        int index1=0;
        int index2=1;
        Integer[][] x = new Integer[10][10];
        for(int i=0; i<=10; i++) {
            for (int j = 0; j <= 10; j++) {
                x[i][j] = Integer.parseInt(tmp.substring(index1+i+j*10,index2+i+j*10));

            }
        }
        return x;


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

