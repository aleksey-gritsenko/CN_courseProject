package po.client;
import java.awt.MouseInfo;
import java.util.concurrent.TimeUnit;

public class Cords {

    public static void main(String[] args) throws InterruptedException {
        while(true){
            TimeUnit.SECONDS.sleep(1/2);
            double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.print("X:" + mouseX);
            System.out.println(", Y:" + mouseY);
        }

    }
}
