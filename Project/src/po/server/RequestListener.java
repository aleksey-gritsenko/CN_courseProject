package po.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestListener {

    private static final Logger LOGGER = Logger.getLogger(RequestListener.class.getName());

    private final int port;
    private final Dispatcher dispatcher = new Dispatcher();

    public RequestListener(int port) {
        this.port = port;
    }

    public void start() {
        final Thread thread = new Thread(new ServerSocketWrapper());
        thread.start();
        LOGGER.info("listener started on port " + port);
    }

    private class ServerSocketWrapper implements Runnable {

        @Override
        public void run() {
            try {
                final ServerSocket serverSocket = new ServerSocket(port);
                final Socket socket = serverSocket.accept();
                LOGGER.log(Level.INFO, "listener connected to {0}", socket.toString());
                while (service(socket)) {

                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }

        private boolean service(Socket socket) throws IOException {
            final InputStream inputStream = socket.getInputStream();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            final String request = bufferedReader.readLine();
            LOGGER.log(Level.INFO, "read: " + request);
            if (dispatcher.isExit(request)) {
                return false;
            }
            final String response = dispatcher.makeResponse(request) + "\n";
            if (null != response) {
                final PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.print(response);
                printWriter.flush();
                LOGGER.log(Level.INFO, "write: {0}", response);
            } else {
                LOGGER.log(Level.WARNING, "unexpected request: {0}", request);                
            }
            return true;
        }

    }

}
