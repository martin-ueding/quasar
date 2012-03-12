public class Schiff
{
  double x;
  double y;
  double a;
  double vr;
  double ar;
  double vx;
  double vy;
  double ax;
  double ay;
  double g = 0.0001D;

  public void move()
  {
    this.vx += this.ax;
    this.vy += this.ay;
    this.vr += this.ar;

    if (Quasar.gravity) {
      this.vy += this.g;
    }
    this.x += this.vx;
    this.y += this.vy;
    this.a += this.vr;
  }
}
