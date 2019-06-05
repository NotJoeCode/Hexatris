package com.notjoecode;

import com.notjoecode.Drawing.MasterDrawer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    //for piece testing
    private int piece = 0;


    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private Piece p = new Piece();
    private MasterDrawer mD = new MasterDrawer(height, p);
    private int xPos = 0;

    public Game(){
        this.setTitle("HEXATRIS");
        this.addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(mD.getBoard().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().height);
        this.add(mD);
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //move piece left
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (int x = 0; x < mD.getPieceDrawer().getBlocks().length; x++) {
                mD.getPieceDrawer().getBlocks()[x].moveLeft();
                //check if the piece has overshot the edge of the board to the left
                if(mD.getPieceDrawer().getBlocks()[x].getPosition()[0] < 0){
                    while(x >= 0){
                        mD.getPieceDrawer().getBlocks()[x].moveRight();
                        x--;
                    }
                    //offset the updated position variable if move cancelled due to board overshoot
                    xPos++;
                    break;
                }
            }
            //used to set the position upon updating the piece
            xPos--;
        }
        //move piece right
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            for(int x=0; x < mD.getPieceDrawer().getBlocks().length; x++ ){
                mD.getPieceDrawer().getBlocks()[x].moveRight();
                //check if the piece has overshot the edge of the board to the right
                if(mD.getPieceDrawer().getBlocks()[x].getPosition()[0] > 14){
                    while(x >= 0){
                        mD.getPieceDrawer().getBlocks()[x].moveLeft();
                        x--;
                    }
                    //offset the position variable if move cancelled due to board overshoot
                    xPos--;
                    break;
                }

            }
            //used to set the position upon updating the piece
            xPos++;
        }
        //turn piece clockwise
        if(e.getKeyCode()==KeyEvent.VK_E){
            //rotate piece clockwise
            p.rotate(p.getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(xPos);
            mD.getPieceDrawer().resetPiecePos(p);

        }
        //turn piece anticlockwise
        if(e.getKeyCode()==KeyEvent.VK_Q){
            //rotate counterclockwise
            p.reverseRotate(p.getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(xPos);
            mD.getPieceDrawer().resetPiecePos(p);

        }

        //move the piece down
        if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){

        }
        //for testing. put the piece at the top of the screen
        if(e.getKeyCode()==KeyEvent.VK_L){
            mD.getPieceDrawer().resetPiecePos(p);
        }
        if(e.getKeyCode() == KeyEvent.VK_K){

            p = new Piece(piece);
            piece++;
            if(piece == 35){piece = 0;}
            mD.getPieceDrawer().resetPiecePos(p);
            mD.setClicks(0);
        }

        mD.repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    public MasterDrawer getMD() { return mD; }
}
