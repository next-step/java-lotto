package Model;

import java.util.ArrayList;

public class WinngNum {
    ArrayList<Integer> winnerNums = new ArrayList<>();

    public WinngNum(ArrayList<Integer> winnerNums) {
        this.winnerNums = winnerNums;
    }

    public ArrayList<Integer> getWinngNum() {
        return this.winnerNums;
    }
}
