package com.notjoecode.Drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Board extends JPanel {
    public static int boxSize;
    private int width, nextBoxHeight, nextBoxWidth, nextBoxPosition;
    //private int height;
    private int points = 0;

    //34 high by 16 wide (y,x)
    private boolean[][] boardState = new boolean[34][15];
    private ArrayList<Block> ocpSpaces = new ArrayList<>();
    private boolean lineCleared;

    private String start = "Press Space to Start";

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

        g.drawString(start, nextBoxWidth, nextBoxWidth);
        g.drawString(Integer.toString(points), width - (boxSize*3)/2, nextBoxHeight + boxSize*2);
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
        //concurrent Modification exception
        for(Block b: ocpSpaces){
            b.paintComponent(g);
        }


    }

    public void setBoardState(Block[] blocks){
        for (Block block : blocks) {
            boardState[(int) block.getPosition()[1]+6][(int) block.getPosition()[0]] = true;
        }
        checkRow();
        for(int x = 0; x < boardState.length; x++) {
            for (int y = 0; y < boardState[x].length; y++) {
                if(boardState[x][y]){
                    ArrayList<Block> temp = new ArrayList<>();
                    temp.add(new Block(y, x-6));
                    ocpSpaces.addAll(temp);
                }
            }
        }
    }

    private void checkRow(){
        int y = 0;
        boolean clearRow = true;
        while(y<boardState.length) {
            for (boolean b : boardState[y]) {
                if (!b) {
                    clearRow = false;
                    y++;
                    break;
                }
            }
            if(clearRow){
                points++;
                for(int z = y; z > 0; z--){
                    for(int x = 0; x < boardState[z].length; x++){
                        boardState[z][x] = boardState[z-1][x];
                    }
                }
                ocpSpaces.clear();
//                for(Block b: ocpSpaces){
//                    if(b.getPosition()[1] == y){
//                        ocpSpaces.remove(b);
//                    }
//                }
                y--;
            }
            clearRow = true;
        }
    }

    public int getWidth(){ return width; }
    public boolean[][] getBoardState() { return boardState; }
    public ArrayList<Block> getAL(){ return ocpSpaces; }
    public void setStart(){start = "";}
}
