import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MKL
  implements KeyListener
{
  public void keyPressed(KeyEvent e)
  {
    int c = e.getKeyCode();

    if (c == 37)
      Quasar.s.ar = -0.002D;
    if (c == 39)
      Quasar.s.ar = 0.002D;
    if (c == 38) {
      Quasar.s.ax = (Math.cos(Quasar.s.a) * 0.001D);
      Quasar.s.ay = (Math.sin(Quasar.s.a) * 0.001D);
    }
  }

  public void keyReleased(KeyEvent e) {
    int c = e.getKeyCode();

    if ((c == 37) || (c == 39))
      Quasar.s.ar = 0.0D;
    if (c == 38) {
      Quasar.s.ax = 0.0D;
      Quasar.s.ay = 0.0D;
    }
  }

  public void keyTyped(KeyEvent arg0)
  {
  }
}
