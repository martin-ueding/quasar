import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Anzeige extends JPanel {
	public static final int RES = 500;
	public static final int schiffXSize = 50;
	public static final int schiffYSize = 25;
	private Schiff s;
	ClassLoader cl;
	Image hintergrund;
	ImageObserver io;

	public Anzeige() {
		this.s = Quasar.s;
		this.cl = getClass().getClassLoader();
		try {
			this.hintergrund = ImageIO.read(this.cl.getResource("hintergrund.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		this.io = this;
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(this.hintergrund, 0, 0, this.io);

		g.setColor(Color.GREEN);

		int xStart = (int)((this.s.x - (int)this.s.x) * 500.0D);
		int yStart = (int)((this.s.y - (int)this.s.y) * 500.0D);

		int unitsWidth = getWidth() / 500;
		int unitsHeight = getHeight() / 500;

		for (int i = 0; i <= unitsWidth + 1; i++) {
			g.drawLine(i * 500 - xStart, 0, i * 500 - xStart, getHeight());
		}
		for (int i = 0; i <= unitsHeight + 1; i++) {
			g.drawLine(0, i * 500 - yStart, getWidth(), i * 500 - yStart);
		}
		Polygon polySchiff = new Polygon();
		polySchiff.addPoint((int)(Math.cos(this.s.a) * -50.0D - Math.sin(this.s.a) * 25.0D) + getWidth() / 2, (int)(Math.sin(this.s.a) * -50.0D + Math.cos(this.s.a) * 25.0D) + getHeight() / 2);
		polySchiff.addPoint((int)(Math.cos(this.s.a) * 50.0D) + getWidth() / 2, (int)(Math.sin(this.s.a) * 50.0D) + getHeight() / 2);
		polySchiff.addPoint((int)(Math.cos(this.s.a) * -50.0D - Math.sin(this.s.a) * -25.0D) + getWidth() / 2, (int)(Math.sin(this.s.a) * -50.0D + Math.cos(this.s.a) * -25.0D) + getHeight() / 2);

		g.setColor(Color.GRAY);
		g.fillPolygon(polySchiff);

		g.setColor(Color.DARK_GRAY);
		g.fillOval(getWidth() / 2 - 5, getHeight() / 2 - 5, 10, 10);

		g.setColor(Color.ORANGE);

		g.drawLine(getWidth() / 2, getHeight() / 2, (int)(getWidth() / 2 + this.s.vx * 1000.0D), (int)(getHeight() / 2 + this.s.vy * 1000.0D));

		g.setColor(Color.BLUE);

		g.drawLine(getWidth() / 2 + 1, getHeight() / 2 + 1, (int)(getWidth() / 2 + this.s.ax * 50000.0D) + 1, (int)(getHeight() / 2 + this.s.ay * 50000.0D) + 1);

		double speed = Math.sqrt(this.s.vx * this.s.vx + this.s.vy * this.s.vy);
		g.setColor(Color.WHITE);
		g.drawString(Spr.get("speed") + ": " + (int)(speed * 1000.0D), 5, 25);
		g.drawString((int)this.s.x + " " + (int)this.s.y, getWidth() - 100, 25);

		g.setColor(Color.ORANGE);
		g.drawString(Spr.get("velocity"), 5, getHeight() - 50);
		g.setColor(Color.BLUE);
		g.drawString(Spr.get("acceleration"), 5, getHeight() - 35);
	}
}
