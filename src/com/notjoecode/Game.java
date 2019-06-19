package com.notjoecode;

import com.notjoecode.Drawing.MasterDrawer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    //for piece testing
    //private int piece = 0;

    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private MasterDrawer mD = new MasterDrawer(height);

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

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            mD.getBoard().setStart();
            mD.start();

        }

        //move piece left
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (int x = 0; x < mD.getPieceDrawer().getBlocks().length; x++) {
                mD.getPieceDrawer().getBlocks()[x].moveLeft(mD.getBoard().getBoardState());
                //check if piece is crashing horizontally
                if(mD.getPieceDrawer().getBlocks()[x].getUndo()) {
                    while (x >= 0) {
                        mD.getPieceDrawer().getBlocks()[x].moveRight(mD.getBoard().getBoardState());
                        mD.getPieceDrawer().getBlocks()[x].setUndo();
                        x--;
                    }
                    break;
                }
                //check if the piece has overshot the edge of the board to the left
                if(mD.getPieceDrawer().getBlocks()[x].getPosition()[0] < 0){
                    while(x >= 0){
                        mD.getPieceDrawer().getBlocks()[x].moveRight(mD.getBoard().getBoardState());
                        mD.getPieceDrawer().getBlocks()[x].setUndo();
                        x--;
                    }
                    //offset the updated position variable if move cancelled due to board overshoot
                    mD.rightOne();
                    break;
                }
            }
            //used to set the position upon updating the piece
            mD.leftOne();
        }
        //move piece right
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            for(int x=0; x < mD.getPieceDrawer().getBlocks().length; x++ ){
                mD.getPieceDrawer().getBlocks()[x].moveRight(mD.getBoard().getBoardState());
                //check if piece is crashing horizontally
                if(mD.getPieceDrawer().getBlocks()[x].getUndo()){
                    while(x >= 0){
                        mD.getPieceDrawer().getBlocks()[x].moveLeft(mD.getBoard().getBoardState());
                        x--;
                    }
                    break;
                }
                //check if the piece has overshot the edge of the board to the right
                if(mD.getPieceDrawer().getBlocks()[x].getPosition()[0] > 14){
                    while(x >= 0){
                        mD.getPieceDrawer().getBlocks()[x].moveLeft(mD.getBoard().getBoardState());
                        x--;
                    }
                    //offset the position variable if move cancelled due to board overshoot
                    mD.leftOne();
                    break;
                }

            }
            //used to set the position upon updating the piece
            mD.rightOne();
        }
        //turn piece clockwise
        if(e.getKeyCode()==KeyEvent.VK_E){
            //rotate piece clockwise
            mD.getP().rotate(mD.getP().getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(mD.getxPos());
            mD.getPieceDrawer().resetPiecePos(mD.getP());

            if(mD.getPieceDrawer().getTurnFailed()){
                mD.getP().reverseRotate(mD.getP().getFinalPiecePos());
                mD.getPieceDrawer().setClicks(mD.getClicks());
                mD.getPieceDrawer().setXPos(mD.getxPos());
                mD.getPieceDrawer().resetPiecePos(mD.getP());
                mD.getPieceDrawer().setTurnFailed();
            }



        }
        //turn piece anticlockwise
        if(e.getKeyCode()==KeyEvent.VK_Q){
            //rotate counterclockwise
            mD.getP().reverseRotate(mD.getP().getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(mD.getxPos());
            mD.getPieceDrawer().resetPiecePos(mD.getP());

            if(mD.getPieceDrawer().getTurnFailed()) {
                mD.getP().rotate(mD.getP().getFinalPiecePos());
                mD.getPieceDrawer().setClicks(mD.getClicks());
                mD.getPieceDrawer().setXPos(mD.getxPos());
                mD.getPieceDrawer().resetPiecePos(mD.getP());
                mD.getPieceDrawer().setTurnFailed();
            }

        }

        //move the piece down
        if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            mD.downButton();
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(mD.getxPos());
            mD.getPieceDrawer().resetPiecePos(mD.getP());
        }
        //for testing. put the piece at the top of the screen
        if(e.getKeyCode()==KeyEvent.VK_L){
            mD.getPieceDrawer().resetPiecePos(mD.getP());
        }
//        if(e.getKeyCode() == KeyEvent.VK_K){
//
//            p = new Piece(piece);
//            piece++;
//            if(piece == 35){piece = 0;}
//            mD.getPieceDrawer().resetPiecePos(p);
//            mD.setClicks(0);
//        }

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
