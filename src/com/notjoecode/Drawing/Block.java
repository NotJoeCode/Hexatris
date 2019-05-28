package com.notjoecode.Drawing;

import javax.swing.*;
import java.awt.*;

public class Block extends JPanel {
    private int size = Board.boxSize;

    private float[] position = new float[2];
    private int[] temp = new int[2];

    public Block(int x, int y){
        this.position[0] = (float) x;
        this.position[1] = (float) y;

    }

    public Block(float x, int y){
        this.position[0] = x;
        this.position[1] = (float) y;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        positionConverter();
        g.setColor(Color.GRAY);
        g.fillRect(temp[0], temp[1], size, size);
        g.setColor(Color.BLACK);
        g.drawRect(temp[0], temp[1], size, size);

    }

    private void positionConverter(){

        temp[0] = (int)((position[0]*size) + size);
        temp[1] = (int)((position[1]*size) + size);

    }


    public void update(){
        position[1]++;
    }
    public void moveRight(){ position[0]++; }
    public void moveLeft(){ position[0]--; }
    public float[] getPosition(){return position;}
    public void setPosition(float[] f){position = f;}


}