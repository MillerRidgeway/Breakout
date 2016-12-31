/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

public class SpeedupBrick extends Brick {
    Block b1;
    public SpeedupBrick(int x, int y, int xLoc, int yLoc, Color color, Block b1) {
        super(x,y,xLoc,yLoc,color,b1);
        this.b1 = b1;
    }

    @Override
    public void hit(Ball b) {
        super.hit(b);
        b.xv = b.xv * 1.3;
        b.yv = b.yv * 1.3;
    }
}
