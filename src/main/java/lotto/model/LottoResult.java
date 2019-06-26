package lotto.model;

public class LottoResult {


    private int winningCount6;
    private int winningCount5;
    private int winningCount4;
    private int winningCount3;

    public LottoResult(int winningCount6, int winningCount5, int winningCount4, int winningCount3) {
        this.winningCount6 = winningCount6;
        this.winningCount5 = winningCount5;
        this.winningCount4 = winningCount4;
        this.winningCount3 = winningCount3;
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
