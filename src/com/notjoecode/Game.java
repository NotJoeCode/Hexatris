package com.notjoecode;

import com.notjoecode.Drawing.MasterDrawer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
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

        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            for (int x = 0; x < mD.getPieceDrawer().getBlocks().length; x++) {
                mD.getPieceDrawer().getBlocks()[x].moveLeft();
            }
            xPos--;
        }
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            for(int x=0; x < mD.getPieceDrawer().getBlocks().length; x++ ){
                mD.getPieceDrawer().getBlocks()[x].moveRight();

            }
            xPos++;
        }
        if(e.getKeyCode()==KeyEvent.VK_E){
            //rotate piece clockwise
            p.rotate(p.getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(xPos);
            mD.getPieceDrawer().resetPiecePos(p);

        }
        if(e.getKeyCode()==KeyEvent.VK_Q){
            //rotate counterclockwise
            p.reverseRotate(p.getFinalPiecePos());
            mD.getPieceDrawer().setClicks(mD.getClicks());
            mD.getPieceDrawer().setXPos(xPos);
            mD.getPieceDrawer().resetPiecePos(p);

        }

        mD.repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
