/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    int x, y;
    private int width, height;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 10;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x - this.width / 2, y, width, height);
    }

    public void bounce(Ball b) {
        if (b.y >= this.y-2 && b.x >= this.x - this.width / 2 && b.x <= this.x + 100) {
            b.yv = -b.yv;
            b.y = b.y-(this.height)/2;
            b.xv = -(this.x - b.x) / 20;
        }
    }

    public void move(int x) {
        this.x = x;
    }
}
