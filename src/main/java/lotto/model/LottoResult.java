package lotto.model;

public class LottoResult {

    private int winningCount3;
    private int winningCount4;
    private int winningCount5;
    private int winningCount6;

    public void addWinningCount(int winningCount) {

        if (winningCount == 3) {
            winningCount3++;
        }

        if (winningCount == 4) {
            winningCount4++;
        }

        if (winningCount == 5) {
            winningCount5++;
        }

        if (winningCount == 6) {
            winningCount6++;
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
