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
    private Piece p;
    private int xPos = 0;

    //to set position post rotation
    private int clicks, nextPiece;

    public MasterDrawer(int height){

        p = new Piece();

        nextPiece = p.getNextPiece();
        //drawing the grid and the next box
        this.b = new Board(height);
        //displays Pieces
        this.pD = new PieceDrawer(p);
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
                pD.getBlocks()[x].update(b.getBoardState());
                if(pD.getBlocks()[x].getFreeze()){
                    //x--;
                    while(x >= 0){

                        pD.getBlocks()[x].revert();
                        x--;
                    }
                    b.setBoardState(pD.getBlocks());
                    for(Block block : b.getAL()){
                        block.repaint();
                    }
                    b.repaint();

                    p = new Piece(nextPiece);
                    xPos = 0;

                    nextPiece = p.getNextPiece();
                    pD = new PieceDrawer(p);
                    clicks = -1;
                    pD.setXPos(0);
                    break;
                }
                x++;
            }
            clicks++;
            repaint();
        }
    };
    public void start(){ timer.scheduleAtFixedRate(t, 200,200); }


    //getters and setters
    public Board getBoard(){ return b; }
    public PieceDrawer getPieceDrawer() {return pD;}
    public int getClicks() { return clicks;}
    public void setClicks(int i) { this.clicks = i; }
    public void downButton(){
        this.clicks++;
        pD.repaint();
        this.repaint();
    }
    public Piece getP(){ return p; }
    public int getxPos(){return xPos;}
    public void rightOne(){xPos++;}
    public void leftOne(){xPos--;}
}
