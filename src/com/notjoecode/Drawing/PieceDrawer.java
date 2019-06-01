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

    private Block[] blocks;
    private Block[] nextBlocks;
    private int thisPiece;

    public PieceDrawer(Piece p){
        blocks = p.getBlocks();
        nextBlocks = p.getNextBlocks();
        thisPiece = p.getThisPiece();
        //drawPiece(p.getBlockPositions());
        drawPiece(p.getFinalPiecePos(), 0, 0);
        p.drawNextPiece(p.getNextBlockPositions());
        //for rotations
        b = p.getBlockPositions();

    }


    private void drawPiece(boolean[][] array, int clicks, int xPos){
        int x = 0, y = 0, z = 0;
        while(x < array.length){
            while(y < array[x].length){

                if(array[x][y]){
                    int positionX = x+4;
                    //if(!array[3][2] && !array[3][1] && !array[3][0]) {
                    if(array.length == 3){
                        positionX += 2;
                    }
                    //else if(!array[4][0] && ! array[4][1]){
                    else if(array.length == 4){
                        positionX += 2;
                    }
                    //else if(!array[5][0]) {
                    else if(array.length == 5){
                        positionX += 1;
                    }
                    //added 10 for testing
                    //blocks[z] = new Block(positionX,y+10);
                    //functional code
                    blocks[z] = new Block(positionX + xPos,y-1 + clicks);
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

//for rotations :: reference
//        for(int x = 0; x < b.length; x++){
//            for(int y = 0; y< b[x].length; y++){
//                if(b[x][y]){
//                    g.setColor(Color.GRAY);
//                    g.fillRect(blockSize*(x+2),blockSize*(y+2),blockSize,blockSize);
//                }
//
//                g.setColor(Color.BLACK);
//                g.drawRect(blockSize*(x+2),blockSize*(y+2),blockSize,blockSize);
//            }
//        }
    }

    //for rotation
    public void resetPiecePos(Piece p){
        b = p.getFinalPiecePos();
        drawPiece(b, clicks, xPos);
        this.repaint();
    }

    public Block[] getBlocks(){ return blocks; }
    public int getThisPiece(){return thisPiece; }
    public void setClicks(int clicks){this.clicks = clicks;}

    public void setXPos(int xPos) { this.xPos = xPos; }
}
