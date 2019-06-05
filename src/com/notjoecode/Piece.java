package com.notjoecode;

import com.notjoecode.Drawing.Block;
import java.util.BitSet;
import java.util.Random;

public class Piece {

    //added for rotation methods
    private boolean[][] finalPiecePos;

    private boolean[][] currentBlockPositions = new boolean[6][6], nextBlockPositions = new boolean[6][6];
    private Random random = new Random();
    private int thisPiece = random.nextInt(35);
    private int nextPiece = random.nextInt(35);

    private BitSet[] bitSets = { new BitSet(6), new BitSet(5), new BitSet(4)};

    public Piece(){

        setArray(thisPiece, currentBlockPositions);
        setArray(nextPiece, nextBlockPositions);
        resizeArray(currentBlockPositions);

    }

    //Piece testing
    public Piece(int x){
        thisPiece = x;
        nextPiece = random.nextInt(35);

        setArray(thisPiece,currentBlockPositions);
        setArray(nextPiece, nextBlockPositions);
        resizeArray(currentBlockPositions);

    }

    private void setArray(int x, boolean[][] blockPositions){
        setArrayOne(x, blockPositions);
        setArrayTwo(x, blockPositions);
        setArrayThree(x, blockPositions);
    }
    private void setArrayOne(int x, boolean[][] blockPositions){
        switch (x){
            case 0:
                bitSets[0].set(0,5);
                blockPositions[0][0] = true;
                blockPositions[1][0] = true;
                blockPositions[2][0] = true;
                blockPositions[3][0] = true;
                blockPositions[4][0] = true;
                blockPositions[5][0] = true;
                break;
            case 1: case 2: case 3:
                bitSets[0].set(0,4);
                blockPositions[0][0] = true;
                blockPositions[1][0] = true;
                blockPositions[2][0] = true;
                blockPositions[3][0] = true;
                blockPositions[4][0] = true;
                break;
            case 4: case 5: case 6: case 7: case 8: case 9: case 10:
                bitSets[0].set(0,3);
                blockPositions[0][0] = true;
                blockPositions[1][0] = true;
                blockPositions[2][0] = true;
                blockPositions[3][0] = true;
                break;
            case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19: case 20: case 21:
                bitSets[0].set(0,2);
                blockPositions[0][0] = true;
                blockPositions[1][0] = true;
                blockPositions[2][0] = true;
                break;
            case 22: case 23: case 24: case 25: case 26: case 27: case 28:
                bitSets[0].set(0,1);
                blockPositions[0][0] = true;
                blockPositions[1][0] = true;
                break;
            case 29: case 30: case 31: case 32:
                bitSets[0].set(0);
                blockPositions[0][0] = true;
                break;
            case 33: case 34:
                bitSets[0].set(1);
                blockPositions[1][0] = true;
                break;

            default:
                break;
        }
    }
    private void setArrayTwo(int x, boolean[][] blockPositions){
        switch (x){
            case 1: case 10:
                bitSets[1].set(0);
                blockPositions[0][1] = true;
                break;
            case 2: case 9: case 21:
                bitSets[1].set(1);
                blockPositions[1][1] = true;
                break;
            case 3: case 20:
                bitSets[1].set(2);
                blockPositions[2][1] = true;
                break;
            case 4:
                bitSets[1].set(3,4);
                blockPositions[3][1] = true;
                blockPositions[4][1] = true;
                break;
            case 5: case 15:
                bitSets[1].set(0,1);
                blockPositions[0][1] = true;
                blockPositions[1][1] = true;
                break;
            case 6: case 16:
                bitSets[1].set(0);
                bitSets[1].set(2);
                blockPositions[0][1] = true;
                blockPositions[2][1] = true;
                break;
            case 7: case 17: case 27: case 28:
                bitSets[1].set(1,2);
                blockPositions[1][1] = true;
                blockPositions[2][1] = true;
                break;
            case 8:
                bitSets[1].set(0);
                bitSets[1].set(3);
                blockPositions[0][1] = true;
                blockPositions[3][1] = true;
                break;
            case 11: case 22: case 26:
                bitSets[1].set(0,2);
                blockPositions[0][1] = true;
                blockPositions[1][1] = true;
                blockPositions[2][1] = true;
                break;
            case 12:
                bitSets[1].set(0);
                bitSets[1].set(2,3);
                blockPositions[0][1] = true;
                blockPositions[2][1] = true;
                blockPositions[3][1] = true;
                break;
            case 13: case 23: case 24: case 25:
                bitSets[1].set(1,3);
                blockPositions[1][1] = true;
                blockPositions[2][1] = true;
                blockPositions[3][1] = true;
                break;
            case 14:
                bitSets[1].set(2,4);
                blockPositions[2][1] = true;
                blockPositions[3][1] = true;
                blockPositions[4][1] = true;
                break;
            case 18: case 19:
                bitSets[1].set(2,3);
                blockPositions[2][1] = true;
                blockPositions[3][1] = true;
                break;
            case 29: case 30: case 31: case 32: case 33: case 34:
                bitSets[1].set(0,3);
                blockPositions[0][1] = true;
                blockPositions[1][1] = true;
                blockPositions[2][1] = true;
                blockPositions[3][1] = true;
            default:
                break;

        }

    }
    private void setArrayThree(int x, boolean[][] blockPositions){
        switch (x){
            case 9: case 17: case 22: case 23: case 30: case 34:
                bitSets[2].set(1);
                blockPositions[1][2] = true;
                break;
            case 10: case 15: case 16: case 29:
                bitSets[2].set(0);
                blockPositions[0][2] = true;
                break;
            case 18: case 24: case 26: case 31: case 33:
                bitSets[2].set(2);
                blockPositions[2][2] = true;
                break;
            case 19: case 25: case 32:
                bitSets[2].set(3);
                blockPositions[3][2] = true;
                break;
            case 20: case 28:
                bitSets[2].set(2,3);
                blockPositions[2][2] = true;
                blockPositions[3][2] = true;
                break;
            case 21: case 27:
                bitSets[2].set(0,1);
                blockPositions[0][2] = true;
                blockPositions[1][2] = true;
                break;
            default:
                break;

        }

    }
    private void resizeArray(boolean[][] array) {
        boolean[][] temp;
        if (!array[3][2] && !array[3][1] && !array[3][0]) {
            temp = new boolean[3][3];
            int x = 0, y = 0;
            while (y < temp.length) {
                while (x < temp[y].length) {
                    temp[y][x] = array[y][x];
                    x++;
                }
                x = 0;
                y++;
            }
        } else if (!array[4][0] && !array[4][1]) {
            temp = new boolean[4][4];
            int x = 0, y = 0;
            while (y < temp.length) {
                while (x + 1 < temp[y].length) {
                    temp[y][x + 1] = array[y][x];
                    x++;
                }
                x = 0;
                y++;
            }
        } else if (!array[5][0]) {
            temp = new boolean[5][5];
            int x = 0, y = 0;
            while (y < temp.length) {
                while (x + 2 < temp[y].length) {
                    temp[y][x + 2] = array[y][x];
                    x++;
                }
                x = 0;
                y++;
            }
        } else {
            temp = new boolean[6][6];
            int x = 0, y = 0;
            while (y < temp.length) {
                while (x + 2 < temp[y].length) {
                    temp[y][x + 2] = array[y][x];
                    x++;
                }
                x = 0;
                y++;
            }
        }
        finalPiecePos = temp;
    }




    public void rotate(boolean[][] test) {

        boolean[][] temp = new boolean[test.length][test.length];
        for(int x = 0; x < temp.length; x++){
            if (temp[x].length >= 0) System.arraycopy(test[x], 0, temp[x], 0, temp[x].length);
        }

        for(int x = 0; x < temp.length; x++) {
            for (int y = 0, z = temp.length - 1; y < temp[x].length; y++, z--) {
                finalPiecePos[z][x] = temp[x][y];
            }
        }

    }

    public void reverseRotate(boolean[][] test){

        boolean[][] temp = new boolean[test.length][test.length];
        for(int x = 0; x < temp.length; x++){
            if (temp[x].length >= 0) System.arraycopy(test[x], 0, temp[x], 0, temp[x].length);
        }

        for(int x = 0, z = temp.length - 1; x < temp.length; x++, z--) {
            for (int y = 0; y < temp[x].length; y++) {
                finalPiecePos[y][z] = temp[x][y];
            }
        }

    }

    public boolean[][] getBlockPositions() { return currentBlockPositions; }
    public boolean[][] getNextBlockPositions() { return nextBlockPositions; }
    public int getThisPiece(){ return thisPiece; }
    public void setThisPiece(){ thisPiece = nextPiece; }
    public int getNextPiece(){ return nextPiece; }
    public void setNextPiece(){nextPiece = random.nextInt(35);}
    public boolean[][] getFinalPiecePos() { return finalPiecePos;}
    public void setFinalPiecePos(boolean[][] temp) { finalPiecePos = temp; }
}
