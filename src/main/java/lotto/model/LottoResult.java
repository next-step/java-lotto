package lotto.model;

public class LottoResult {


    private int winningCount6;
    private int winningCount5;
    private int winningCount4;
    private int winningCount3;

    public void addWinningCount(int winningCount){

        if (winningCount == 3){
            winningCount3++;
        }

    }

    public int getWinningCount6() {
        return winningCount6;
    }

    public int getWinningCount5() {
        return winningCount5;
    }

    public int getWinningCount4() {
        return winningCount4;
    }

    public int getWinningCount3() {
        return winningCount3;
    }
}
