import java.awt.Color;
import java.awt.Graphics;

public class Ball {

    double x, y, xv, yv;
    public int prevx, prevy;
    Color ballColor;

    public Ball(double x, double y, double xv, double yv, Color ballColor) {
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.ballColor = ballColor;
    }

    public void paint(Graphics g) {
        g.setColor(this.ballColor);
        g.fillOval((int) x-5, (int) y-5, 10, 10);
    }

    public void bounce() {
        prevx = (int) x;
        prevy = (int) y;
        x = x + xv;
        y = y + yv;

        if (y <= 5) {
            yv = -yv;
            this.y = this.y+5;
        } else if (x <= 0) {
            xv = -xv;
            this.x = this.x+5;
        } else if (x >= Main.fieldWidth - 5) {
            xv = -xv;
            this.x = this.x-5;
        }
    }
}
