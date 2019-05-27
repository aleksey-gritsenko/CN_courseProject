package po.client;

import po.server.POServer;
import po.server.ServMain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BeginClient {
    public static void main(String[] args) {
        // new Thread(POServer::main()).start();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit((Runnable) POClient::main);
        pool.submit((Runnable) ClientMain::main);

    }
    }
