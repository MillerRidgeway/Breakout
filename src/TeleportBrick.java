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
public class TeleportBrick extends Brick {
    Block b1;
    public TeleportBrick(int x, int y, int xLoc, int yLoc, Color color,Block b1) {
        super(x, y, xLoc, yLoc, color,b1);
        this.b1 = b1;
    }

    @Override
    public void hit(Ball b) {
        super.hit(b);
        b.y = 0;
    }

}
