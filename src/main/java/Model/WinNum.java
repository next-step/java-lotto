package Model;

import java.util.ArrayList;

public class WinNum {
    ArrayList<Integer> winNum = new ArrayList<>();

    public WinNum(ArrayList<Integer> winnerNums) {
        this.winNum = winnerNums;
    }

    public ArrayList<Integer> getWinNum() {
        return this.winNum;
    }
}
