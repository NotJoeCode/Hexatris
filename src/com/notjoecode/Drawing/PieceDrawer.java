package com.notjoecode.Drawing;

import com.notjoecode.Piece;
import javax.swing.*;
import java.awt.*;

public class PieceDrawer extends JPanel{

    //used for rotations
    private boolean[][] b;

    private Block[] blocks;
    private Block[] nextBlocks;
    private int thisPiece;

    public PieceDrawer(Piece p){
        blocks = p.getBlocks();
        nextBlocks = p.getNextBlocks();
        thisPiece = p.getThisPiece();
        p.drawPiece(p.getBlockPositions());
        p.drawNextPiece(p.getNextBlockPositions());
        //for rotations
        b = p.getBlockPositions();

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
    }

    public Block[] getBlocks(){ return blocks; }
    public int getThisPiece(){return thisPiece; }

}
