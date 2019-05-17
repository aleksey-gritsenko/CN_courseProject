package po.client;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class POClient extends JFrame {
    
    private final Connector connector;
    private final Field field = new Field();
    
    public POClient(String host, int port) {
        super("Project One Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.connector = new Connector(host, port, field);
        getContentPane().add(createContent());
        pack();        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( ()-> {
            final POClient mainFrame = new POClient("localhost", 3000);
            mainFrame.setVisible(true);
            mainFrame.connector.startGame();
        });
    }
    
    private JPanel createContent() {
        final JPanel result = new JPanel();
        final JPanel header = new JPanel();
        result.setLayout( new BorderLayout());
        result.add( BorderLayout.NORTH, header);
        result.add( BorderLayout.CENTER, field);
        
        final JButton makeMove = new JButton("Make Move");
        final JButton endGame = new JButton("End Game");
        header.add(makeMove);
        header.add(endGame);
        
        makeMove.addActionListener( event -> this.connector.makeMove());
        endGame.addActionListener( event -> this.connector.endGame());
        
        return result;
    }
    
}
