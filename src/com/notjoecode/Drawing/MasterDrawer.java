package com.notjoecode.Drawing;

import com.notjoecode.Piece;
import javax.swing.JPanel;
import java.awt.*;
import java.util.*;

public class MasterDrawer extends JPanel{

    private Timer timer = new Timer();
    private Board b;
    private PieceDrawer pD;

    public MasterDrawer(int height, Piece p){
        this.b = new Board(height);
        pD = new PieceDrawer(p);
        start();
    }

    private TimerTask t = new TimerTask() {
        @Override
        public void run() {
            int x = 0;
            while (x < pD.getBlocks().length) {
                pD.getBlocks()[x].update();
                x++;
                repaint();
            }
            repaint();
        }
    };

    @Override
    public void paintComponent(Graphics g){
        b.paintComponent(g);
        pD.paintComponent(g);
    }

    private void start(){
        timer.scheduleAtFixedRate(t, 1000,1000);
    }

    public Board getBoard(){
        return b;
    }
    public PieceDrawer getpD() {return pD;}

}
