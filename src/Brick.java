/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;

public class Brick {

    int x, y, xLoc, yLoc;
    Color color;
    int selfDef = 0;
    Block b1;

    public Brick() {
    }//Null Constructor

    public Brick(int x, int y, int xCord, int yCord, Color color, Block b1) {
        this.x = x;
        this.y = y;
        this.xLoc = xCord;
        this.yLoc = yCord;
        this.color = color;
        this.b1 = b1;
    }

    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, b1.brickWidth, b1.brickHeight);
    }

    public void tick() {
    }

    public void hit(Ball b) {
        if (b.prevy > this.y) {
            b.yv = -b.yv;
            b.y = b.y + Main.brickHeight;
            Main.score++;
        }
        if (b.prevy < this.y && b.yv > 0) {
            b.yv = -b.yv;
            Main.score++;
        }
        if (b.prevx > this.x + Main.brickWidth) {
            b.xv = -b.xv;
            b.x = 2 * (this.x + Main.brickWidth) - b.x;
            Main.score++;
        }
        if (b.prevx < this.x) {
            b.xv = -b.xv;
            b.x = 2 * (this.x) - b.x;
            Main.score++;
        }
        b1.bs[this.xLoc][this.yLoc] = null;
    }
}
