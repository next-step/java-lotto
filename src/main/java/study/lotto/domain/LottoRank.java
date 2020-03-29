package study.lotto.domain;

public enum LottoRank {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000);

    private int prize;

    LottoRank(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
