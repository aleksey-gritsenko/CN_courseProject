package po.server;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static sun.jvm.hotspot.runtime.PerfMemory.start;

public class BeginServer {
    public static void main(String[] args) {
       // new Thread(POServer::main()).start();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit((Runnable) POServer::main);
        pool.submit((Runnable) ServMain::main);

    }
}
