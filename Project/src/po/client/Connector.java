package po.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connector {

    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    private final int port;
    private final String host;
    private final Field field;

    private Socket socket = null;

    public Connector(String host, int port, Field field) {
        this.host = host;
        this.port = port;
        this.field = field;
    }

    public void startGame() {
        try {
            socket = new Socket(host, port);
        } catch (IOException ex) {
            showError(ex);
        }
    }

    public String makeMove(int x, int y, int player) {
        try {
            PrintWriter w = getWriter();
            String request = "M." + String.valueOf(x) + "." + String.valueOf(y) + "." + String.valueOf(player) + "\n";
            //make request in format "M." + x.toString() + "." + y.toString() + "." + playerNumber.toString
            w.print(request);
            w.flush();
            final String response = getReader().readLine();
            String resp = response.toString();
            LOGGER.log(Level.INFO, "RESPONSE = {0}", response);
            return  resp;

        } catch (IOException ex) {
            showError(ex);
        }
        return null;

    }

    public void endGame() {
        try {            
            PrintWriter w = getWriter();
            w.print("E\n");
            w.flush();
            socket.close();
            socket = null;
        } catch (IOException ex) {
            showError(ex);
        }

    }

    private void showError(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        LOGGER.log(Level.SEVERE, null, ex);
    }
    
    private final BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    private final PrintWriter getWriter() throws IOException {
        return new PrintWriter(socket.getOutputStream(),true);
    }

}
