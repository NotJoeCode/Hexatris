package com.notjoecode;

import com.notjoecode.Drawing.Block;
import java.util.BitSet;
import java.util.Random;

public class Piece {

    boolean turned;

    private Block[] blocks = new Block[6];
    private Block[] nextBlocks = new Block[6];

    private BitSet[] bitSets = { new BitSet(6), new BitSet(5), new BitSet(4)};
    private boolean[][] currentBlockPositions = new boolean[6][3], nextBlockPositions = new boolean[6][3];
    private Random random = new Random();
    private int thisPiece = random.nextInt(35);
    private int nextPiece = random.nextInt(35);

    public Piece(){
        setArray(thisPiece, currentBlockPositions);
        setArray(nextPiece, nextBlockPositions);

    }

    public void drawPiece(boolean[][] array){
        int x = 0, y = 0, z = 0;
        while(x < array.length){
            while(y < array[x].length){

                if(array[x][y]){
                    int positionX = x+4;
                    if(!array[3][2] && !array[3][1] && !array[3][0]) {
                        positionX += 2;
                    }
                    else if(!array[4][0] && ! array[4][1]){
                        positionX += 2;
                    }
                    else if(!array[5][0]) {
                        positionX += 1;
                    }
                    blocks[z] = new Block(positionX,y);
                    z++;
                }
                y++;
            }
            y = 0;
            x++;
        }
    }

    public void drawNextPiece(boolean[][] array){
        int x = 0, y = 0, z = 0;
        while(x < array.length){
            while(y < array[x].length){

                if(array[x][y]){
                    float positionX = x+16;
                    if(!array[3][2] && !array[3][1] && !array[3][0]) {
                        positionX += 1.5;
                    }
                    else if(!array[4][0] && ! array[4][1]){
                        positionX += 1;
                    }
                    else if(!array[5][0]) {
                        positionX += .5;
                    }
                    nextBlocks[z] = new Block(positionX,y);
                    z++;
                }
                y++;
            }
            y = 0;
            x++;
        }
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

    public void turnPiece(boolean b){
        float[] temp;
        int x = 2, y = 0;
        switch (thisPiece) {
            case 5: case 10: case 15: case 16:
                x = 0;
                break;
            case 9:
                x = 1;
                break;
            case 21: case 22: case 26:
                x = 3;
                break;
            default:
                break;
        }
        temp = blocks[x].getPosition();
        if((b && !turned)||(!b && turned)){
            while(y < blocks.length){
                float xPos = temp[0] + (temp[1] - blocks[y].getPosition()[1]);
                float yPos = temp[1] + (temp[0] - blocks[y].getPosition()[0]);
                blocks[y].setPosition(new float[] {xPos, yPos});
                y++;
            }
        }
        else {
            while(y < blocks.length){
                float xPos = temp[0] + (blocks[y].getPosition()[1] - temp[1]);
                float yPos = temp[1] + (blocks[y].getPosition()[0] - temp[0]);
                blocks[y].setPosition(new float[] {xPos, yPos});
                y++;
            }
        }
        turned = !turned;


    }


    public boolean[][] getBlockPositions() { return currentBlockPositions; }
    public boolean[][] getNextBlockPositions() { return nextBlockPositions; }
    public int getThisPiece(){ return thisPiece; }
    public void setThisPiece(){ thisPiece = nextPiece; }
    public int getNextPiece(){ return nextPiece; }
    public void setNextPiece(){nextPiece = random.nextInt(35);}
    public Block[] getBlocks(){return blocks;}
    public Block[] getNextBlocks(){return nextBlocks;}
}
