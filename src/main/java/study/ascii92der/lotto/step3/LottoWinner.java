package study.ascii92der.lotto.step3;

public enum LottoWinner {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    int matchNumberCount;
    int winnerPrice;

    LottoWinner(int matchNumberCount, int winnerPrice) {
        this.matchNumberCount = matchNumberCount;
        this.winnerPrice = winnerPrice;
    }
}
