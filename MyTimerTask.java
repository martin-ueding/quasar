import java.util.TimerTask;
import javax.swing.JFrame;

public class MyTimerTask extends TimerTask {
	public void run() {
		Quasar.s.move();
		Quasar.frame.repaint();
	}
}
