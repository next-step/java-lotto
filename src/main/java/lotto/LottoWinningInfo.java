package lotto;

public enum LottoWinningInfo {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000);

    private int matchCount;
    private int winningAmount;

    LottoWinningInfo(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static int valueOf(int matchCount) {
        int amount = 0;
        switch (matchCount) {
            case 3:
                amount = THIRD.getWinningAmount();
                break;
            case 4:
                amount = FOURTH.getWinningAmount();
                break;
            case 5:
                amount = FIFTH.getWinningAmount();
                break;
            case 6:
                amount = SIXTH.getWinningAmount();
                break;
            default:
                break;
        }

        return amount;
    }
}
