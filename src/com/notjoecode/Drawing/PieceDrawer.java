package com.notjoecode.Drawing;

import com.notjoecode.Piece;
import javax.swing.*;
import java.awt.*;

public class PieceDrawer extends JPanel{

    private Block[] blocks;
    private Block[] nextBlocks;
    private int thisPiece;

    public PieceDrawer(Piece p){
        blocks = p.getBlocks();
        nextBlocks = p.getNextBlocks();
        thisPiece = p.getThisPiece();
        p.drawPiece(p.getBlockPositions());
        p.drawNextPiece(p.getNextBlockPositions());

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



    public Block[] getBlocks(){ return blocks; }
    public int getThisPiece(){return thisPiece; }

}
