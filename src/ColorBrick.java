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
public class ColorBrick extends Brick {

    Color[] colors;
    private int changeTimer;
    private int colorPos = 0;
    public int timer = 100;
    Block b1;

    public ColorBrick() {
        //Null constructor 
    }

    public ColorBrick(int x, int y, int xLoc, int yLoc, Color[] colors, Block b1) {
        super(x, y, xLoc, yLoc, colors[0],b1);
        this.colors = colors;
        this.b1 = b1;
    }

    @Override
    public void tick() {
        changeTimer++;
        if (changeTimer % timer == 0) {
            if (colorPos < 4) {
                colorPos++;
            } else {
                colorPos = 0;
            }
            super.color = colors[colorPos];
        }
    }
}
