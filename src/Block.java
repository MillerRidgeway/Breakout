/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author stu340407
 */
public class Block {

    int x, y, cols, rows, brickWidth, brickHeight;
    Color c1, c2;
    Brick bs[][];
    Color colors[];

    public Block(int x, int y, int rows, int cols, int brickWidth, int brickHeight, Color c1, Color c2) {
        this.x = x;
        this.y = y;
        this.rows = rows;
        this.cols = cols;
        this.c1 = c1;
        this.c2 = c2;
        this.brickWidth = brickWidth;
        this.brickHeight = brickHeight;
        colors = new Color[]{Color.ORANGE, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.WHITE};
        bs = new Brick[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i+j)% 2 == 0) {
                    bs[i][j] = new Brick(i * brickWidth + x, j * brickHeight + y, i, j, c1, this);
                }  else {
                    bs[i][j] = new Brick(i * brickWidth + x, j * brickHeight + y, i, j, c2, this);
                }
            }
        }
        this.randomType();
    }

    public void tick() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (bs[i][j] != null) {
                    bs[i][j].tick();
                }
            }
        }
    }

    public void display(Graphics g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (bs[i][j] != null) {

                    bs[i][j].paint(g);
                }
            }
        }

    }

    public Brick brickAt(double x, double y) {
        int i = (int) ((x - this.x) / brickWidth);
        int j = (int) ((y - this.y) / brickHeight);
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return bs[i][j];
        } else {
            return null;
        }
    }

    public void randomType() {
        Random r = new Random();
        int randType = r.nextInt(6);
        int randI = r.nextInt(rows);
        int randJ = r.nextInt(cols);

        switch (randType) {
            case 1:
                bs[randI][randJ] = new SpeedupBrick(randI * brickWidth + x, randJ * brickHeight + y, randI, randJ, Color.WHITE, this);
                break;
            case 2:
                bs[randI][randJ] = new HardBrick(randI * brickWidth + x, randJ * brickHeight + y, randI, randJ, colors, this);
                break;
            case 3:
                bs[randI][randJ] = new ColorBrick(randI * brickWidth + x, randJ * brickHeight + y, randI, randJ, colors, this);
                break;
            case 4:
                bs[randI][randJ] = new TeleportBrick(randI * brickWidth + x, randJ * brickHeight + y, randI, randJ, Color.MAGENTA, this);
                break;
            case 5:
                bs[randI][randJ] = new ComboBrick(randI * brickWidth + x, randJ * brickHeight + y, randI, randJ, Color.GREEN,this);
                break;
            default:
                bs[randI][randJ] = new Brick(randI * Main.brickWidth + x, randJ * brickHeight + y, randI, randJ, Color.PINK, this);
                break;
        }

    }
}
