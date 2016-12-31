/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

/**
 *
 * @author Miller
 */
public class HardBrick extends ColorBrick {

    public int counter = 0;
    Color[] colors = new Color[5];
    Block b1;

    public HardBrick(int x, int y, int xLoc, int yLoc, Color[] colors, Block b1) {
        super(x, y, xLoc, yLoc, colors,b1);
        this.b1 = b1;
        super.timer = 20;
    }

    @Override
    public void hit(Ball b) {
        super.hit(b);
        counter++;
        if (counter < 3) {
            b1.bs[this.xLoc][this.yLoc] = this;
        }
    }
}
