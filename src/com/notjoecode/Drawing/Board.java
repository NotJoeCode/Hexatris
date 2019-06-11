package com.notjoecode.Drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Board extends JPanel {
    public static int boxSize;
    private int width, nextBoxHeight, nextBoxWidth, nextBoxPosition;
    //private int height;

    private boolean[][] boardState = new boolean[16][34];
    private ArrayList<Block> ocpSpaces = new ArrayList<>();

    public Board(int height){

        //this.height = height;
        boxSize = height/30;
        nextBoxHeight = boxSize * 4;
        nextBoxWidth = boxSize * 6;
        nextBoxPosition = boxSize*16;
        width = nextBoxPosition + nextBoxWidth + (2*boxSize);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        //set the vertical lines | | | |
        for(int x = 14; x != 0; x-- ) {
            g.drawLine(boxSize + (x*boxSize), boxSize, boxSize+(x*boxSize),boxSize*28);
        }
        //set the horizontal lines - - - - -
        for(int x = 26; x != 0; x --) {
            g.drawLine(boxSize, boxSize + (x * boxSize),  boxSize*16, boxSize + (x * boxSize));
        }
        g.setColor(Color.BLACK);
        //g.drawRect(boxSize, boxSize, (height )/2, height - (4 * boxSize));
        g.drawRect(boxSize,boxSize,boxSize*15,boxSize*27);

        g.drawRect(nextBoxPosition+boxSize, boxSize, nextBoxWidth, nextBoxHeight);
        for(Block b: ocpSpaces){
            b.paintComponent(g);
        }

    }

    public void setBoardState(Block[] blocks){
        for (Block block : blocks) {
            boardState[(int) block.getPosition()[0]][(int) block.getPosition()[1]+6] = true;
        }
        for(int x = 0; x < boardState.length; x++) {
            for (int y = 0; y < boardState[x].length; y++) {
                if(boardState[x][y]){
                    ocpSpaces.add(new Block(x, y-6));
                }
            }
        }
    }

    public int getWidth(){ return width; }
    public boolean[][] getBoardState() { return boardState; }
    public ArrayList<Block> getAL(){ return ocpSpaces; }
}
