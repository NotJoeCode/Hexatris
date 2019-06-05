package com.notjoecode.Drawing;

import com.notjoecode.Piece;
import javax.swing.*;
import java.awt.*;

public class PieceDrawer extends JPanel{

    //used for rotations
    private boolean[][] b;
    //for correct y after rotation
    private int clicks;
    //for correct x after rotation
    private int xPos;


    private boolean breaker = false;

    private Block[] blocks, nextBlocks, oldB;

    public PieceDrawer(Piece p){
        blocks = new Block[6];
        nextBlocks = new Block[6];
        drawNextPiece(p.getNextBlockPositions());
        drawPiece(p.getFinalPiecePos(), 0, 0);
        drawNextPiece(p.getNextBlockPositions());
        //for rotations
        b = p.getBlockPositions();

    }

    private void drawPiece(boolean[][] array, int clicks, int xPos){
        int x = 0, y = 0, z = 0, offset=-2;
        while(x < array.length){
            while(y < array[x].length){

                if(array[x][y]){
                    int positionX = x+4;
                    //if(!array[3][2] && !array[3][1] && !array[3][0]) {
                    if(array.length == 3){
                        positionX += 2;
                        offset = 0;
                    }
                    //else if(!array[4][0] && ! array[4][1]){
                    else if(array.length == 4){
                        positionX += 2;
                        offset = -1;
                    }
                    //else if(!array[5][0]) {
                    else {
                        positionX += 1;
                    }
                    //added 10 for testing
                    //blocks[z] = new Block(positionX,y+10);
                    //functional code
                    blocks[z] = new Block(positionX + xPos,y+offset + clicks);

                    //prevent turning off the screen
                    if(blocks[z].getPosition()[0] < 0 || blocks[z].getPosition()[0] > 14){
                        blocks = oldB;
                        this.breaker = true;
                        break;
                    }
                    z++;
                }
                y++;
            }
            if(this.breaker) break;
            y = 0;
            x++;
        }
    }
    private void drawNextPiece(boolean[][] array){
        int x = 0, y = 0, z = 0;
        while(x < array.length){
            while(y < array[x].length){

                if(array[x][y]){
                    float positionX = x+16;
                    if(!array[3][2] && !array[3][1] && !array[3][0]) {
                        positionX += 1.5;
                    }
                    else if(!array[4][0] && ! array[4][1]){
                        positionX += 1;
                    }
                    else if(!array[5][0]) {
                        positionX += .5;
                    }
                    nextBlocks[z] = new Block(positionX,y);
                    z++;
                }
                y++;
            }
            y = 0;
            x++;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = 0;
        while( x < blocks.length){
            blocks[x].paintComponent(g);
            x++;
        }
        int y = 0;
        while( y < nextBlocks.length){
            nextBlocks[y].paintComponent(g);
            y++;
        }
    }

    //for rotation
    public void resetPiecePos(Piece p){
        oldB = new Block[blocks.length];
        System.arraycopy(blocks,0,oldB,0,oldB.length);
        boolean[][] temp = new boolean[b.length][b.length];
        for(int x = 0; x < temp.length; x++){
            if (temp[x].length >= 0) System.arraycopy(b[x], 0, temp[x], 0, temp[x].length);
        }

        b = p.getFinalPiecePos();
        drawPiece(b, clicks, xPos);
        if(this.breaker){
            p.setFinalPiecePos(temp);
            breaker = false;

        }
        this.repaint();
    }

    public Block[] getBlocks(){ return blocks; }
    public void setClicks(int clicks){this.clicks = clicks;}

    public void setXPos(int xPos) { this.xPos = xPos; }
}
