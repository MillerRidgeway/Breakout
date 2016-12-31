/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;

public class ComboBrick extends Brick {

    int n = -1;
    int prevI;
    int prevJ;
    public static int sPrevI;
    public static int sPrevJ;
    public static int sn = 1;
    public static Block sb1;
    Block block1;

    public ComboBrick(int x, int y, int xLoc, int yLoc, Color c,Block b1) {
        super(x, y, xLoc, yLoc, c, b1);
        this.block1 = sb1;
        this.sb1 = b1;
        this.n = sn;
        sn++;
        this.prevI = sPrevI;
        this.prevJ = sPrevJ;
        this.sPrevJ = yLoc;
        this.sPrevI = xLoc;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        g.drawString("" + n, super.x + Main.brickWidth / 2, super.y + 9);
    }

    @Override
    public void hit(Ball b) {
        super.hit(b);
        if(n != 1 && block1.bs[prevI][prevJ] != null)
            b1.bs[xLoc][yLoc] = this;
    }
}
