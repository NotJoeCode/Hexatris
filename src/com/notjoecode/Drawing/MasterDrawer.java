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

    public MasterDrawer(int height, Piece p){
        //drawing the grid and the next box
        this.b = new Board(height);
        //creates the visual representation of the Piece class logic
        this.pD = new PieceDrawer(p);
        start();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        b.paintComponent(g);
        pD.paintComponent(g);
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
