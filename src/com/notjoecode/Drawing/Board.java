package com.notjoecode.Drawing;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public static int boxSize;
    private int height, width, nextBoxHeight, nextBoxWidth, nextBoxPosition;

    public Board(int height){

        this.height = height;
        boxSize = height/30;
        nextBoxHeight = boxSize * 4;
        nextBoxWidth = boxSize * 6;
        nextBoxPosition = (height/2) + (boxSize);
        width = nextBoxPosition + nextBoxWidth + (2*boxSize);

    }

    @Override
    public void paintComponent(Graphics g){

        g.setColor(Color.LIGHT_GRAY);
        for(int x = 14; x != 0; x-- ) {
            g.drawLine(boxSize + (x*boxSize), boxSize, boxSize+(x*boxSize),height-(3*boxSize));
        }
        for(int x = 26; x != 0; x --) {
            g.drawLine(boxSize, boxSize + (x * boxSize), (height / 2) + boxSize, boxSize + (x * boxSize));
        }
        g.setColor(Color.BLACK);
        g.drawRect(boxSize, boxSize, (height )/2, height - (4 * boxSize));
        g.drawRect(nextBoxPosition+boxSize, boxSize, nextBoxWidth, nextBoxHeight);

    }

    public int getWidth(){
        return width;
    }

}
