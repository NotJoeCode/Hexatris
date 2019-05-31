package com.notjoecode.Drawing;

import com.notjoecode.Piece;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;


//Creates and draws all of the element to the game panel, along with controlling the flow of the game.
public class MasterDrawer extends JPanel{

    private Timer timer = new Timer();
    private Board b;
    private PieceDrawer pD;
    //to set position post rotation
    private int clicks;

    public MasterDrawer(int height, Piece p){
        //drawing the grid and the next box
        this.b = new Board(height);
        //displays Pieces
        this.pD = new PieceDrawer(p);
        start();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        b.paintComponent(g);
        pD.paintComponent(g);
        //testing for rotations
        //g.drawRect(Board.boxSize*6,Board.boxSize*9,Board.boxSize*6,Board.boxSize*6);
        //g.fillRect(Board.boxSize*9 -5, Board.boxSize*12-5,10,10);
        //
    }

    //GameLoop
    private TimerTask t = new TimerTask() {
        @Override
        public void run() {
            int x = 0;
            while (x < pD.getBlocks().length) {
                pD.getBlocks()[x].update();
                x++;
            }
            clicks++;
            repaint();
        }
    };
    private void start(){
        timer.scheduleAtFixedRate(t, 1000,1000);
    }


    //getters and setters
    public Board getBoard(){
        return b;
    }
    public PieceDrawer getPieceDrawer() {return pD;}

}
