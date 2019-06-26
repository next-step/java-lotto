package lotto;

public enum LottoWinningCondition {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private int winMatchCount;
    private int winMoney;

    LottoWinningCondition(int winMatchCount, int winMoney) {
        this.winMatchCount = winMatchCount;
        this.winMoney = winMoney;
    }

    public int getWinMatchCount() {
        return winMatchCount;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public static LottoWinningCondition findByWinMatchCount(int matchCount) {
        for (LottoWinningCondition lottoWinningCondition : values()) {
            if (lottoWinningCondition.getWinMatchCount() == matchCount) {
                return lottoWinningCondition;
            }
        }
        return null;
    }
}
