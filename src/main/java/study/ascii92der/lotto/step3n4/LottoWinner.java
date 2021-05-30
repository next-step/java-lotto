package study.ascii92der.lotto.step3n4;

public enum LottoWinner {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

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
