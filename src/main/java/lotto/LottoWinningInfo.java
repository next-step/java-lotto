package lotto;

public enum LottoWinningInfo {
    THIRD(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    SIXTH(6, 2_000_000_000);

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

    public static LottoWinningInfo valueOf(int matchCount) {
        LottoWinningInfo lottoWinningInfo = null;
        switch (matchCount) {
            case 3:
                lottoWinningInfo = THIRD;
                break;
            case 4:
                lottoWinningInfo = FOURTH;
                break;
            case 5:
                lottoWinningInfo = FIFTH;
                break;
            case 6:
                lottoWinningInfo = SIXTH;
                break;
            default:
                break;
        }

        return lottoWinningInfo;
    }
}
