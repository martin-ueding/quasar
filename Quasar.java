import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Quasar {
	static Schiff s;
	static JFrame frame;
	static boolean gravity;

	public static void main(String[] args) {
		gravity = JOptionPane.showConfirmDialog(null, Spr.get("schw"), Spr.get("gravity"), 0) == 0;

		s = new Schiff();

		frame = new JFrame("Quasar");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(3);
		frame.add(new Anzeige());
		frame.setVisible(true);

		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 1000L, 40L);

		frame.addKeyListener(new MKL());
	}
}
