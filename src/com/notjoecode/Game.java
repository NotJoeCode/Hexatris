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
        if(e.getKeyCode() == KeyEvent.VK_A) {
            for (int x = 0; x < mD.getpD().getBlocks().length; x++) {
                mD.getpD().getBlocks()[x].moveLeft();
                mD.repaint();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            for(int x=0; x < mD.getpD().getBlocks().length; x++ ){
                mD.getpD().getBlocks()[x].moveRight();
                mD.repaint();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_E){
            p.turnPiece(true);
            mD.repaint();
        }
        if(e.getKeyCode()==KeyEvent.VK_Q){
            p.turnPiece(false);
            mD.repaint();
        }

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
