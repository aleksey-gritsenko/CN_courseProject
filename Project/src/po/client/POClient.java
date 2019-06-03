package po.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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

    public static void main() {
        SwingUtilities.invokeLater( ()-> {
            final POClient mainFrame = new POClient("localhost", 3000);
            mainFrame.setVisible(true);
            mainFrame.connector.startGame();
        });
    }
    private Integer[][] map = new Integer[10][10];
    private String stMap = "1111111111" +
            "1200000001" +
            "1000000001" +
            "1000000001" +
            "1000000001" +
            "1000000001" +
            "1000000001" +
            "1000000001" +
            "1000000021" +
            "1111111111";
    private JPanel createContent() {
        JPanel result = new JPanel();
        final JPanel header = new JPanel();
        result.setLayout( new BorderLayout());
        result.add( BorderLayout.NORTH, header);
        //result.add( BorderLayout.CENTER, field);
        map = this.Parse(stMap);
        final JButton makeMove = new JButton("Make Move");
        final JButton endGame = new JButton("End Game");
        header.add(makeMove);
        header.add(endGame);
        String str;
        //refresh map
        Box panel = Box.createVerticalBox();
        int j = 0;
        int i = 0;

        final int[] X = {0};
        final int[] Y = {0};


        for(i = 0; i < 10; i++){
            Box group = Box.createHorizontalBox();
            for (j = 0; j  < 10; j++){
                int finalI = i;
                int finalJ = j;
                JButton button = new JButton(" "){{
                    if (map[finalI][finalJ].intValue() == 0)
                        setBackground(Color.white);
                    if (map[finalI][finalJ].intValue() == 1)
                        setBackground(Color.orange);
                    if (map[finalI][finalJ].intValue() == 2)
                        setBackground(Color.red);

                }};

                button.addActionListener(e -> {
                    X[0] = finalJ;
                    Y[0] = finalI;

                    System.out.println(map[finalI][finalJ]);
                });
                group.add(button);
            }
            panel.add(group);
        }
        result.add(panel);
        makeMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //refresh map
                String res = connector.makeMove(X[0], Y[0],0);
                map = POClient.Parse(res);




                panel.removeAll();
                int j = 0;
                int i = 0;
                for(i = 0; i < 10; i++){
                    Box group = Box.createHorizontalBox();
                    for (j = 0; j  < 10; j++){
                        int finalI = i;
                        int finalJ = j;
                        JButton button = new JButton(" "){{
                            if (map[finalI][finalJ].intValue() == 0)
                                setBackground(Color.white);
                            if (map[finalI][finalJ].intValue() == 1)
                                setBackground(Color.orange);
                            if (map[finalI][finalJ].intValue() == 2)
                                setBackground(Color.red);

                        }};

                        button.addActionListener(ev -> {
                            X[0] = finalJ;
                            Y[0] = finalI;
                            
                        });
                        group.add(button);
                    }
                    panel.add(group);
                }
                panel.revalidate();
                result.repaint();
            }
        });

        endGame.addActionListener( event -> this.connector.endGame());
        
        return result;
    }
//    private Box drawMap(){

//        return panel;
//    }
    public static Integer[][] Parse(String request){
        StringBuilder tmp = new StringBuilder(request);
        int index1=0;
        int index2=1;
        Integer[][] x = new Integer[10][10];
        for(int i=0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                x[i][j] = Integer.parseInt(tmp.substring(index1+j+i*10,index2+j+i*10));

            }
        }
        return x;


    }
    
}
