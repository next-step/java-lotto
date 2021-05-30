package study.ascii92der.lotto.step3n4;

public enum LottoWinner {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchNumberCount;
    private final int winnerPrice;

    LottoWinner(int matchNumberCount, int winnerPrice) {
        this.matchNumberCount = matchNumberCount;
        this.winnerPrice = winnerPrice;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinnerPrice() {
        return winnerPrice;
    }
}
