package lotto.domain;

public enum LottoRank {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    SIX(6, 2_000_000_000L);

    private final int number;
    private final Long prizeMoney;

    LottoRank(int number, Long prizeMoney) {
        this.number = number;
        this.prizeMoney = prizeMoney;
    }

    public int matchNumber() {
        return this.number;
    }

    public Long prize() {
        return this.prizeMoney;
    }

    public static LottoRank findMatchNumber(int matchNumber) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.number == matchNumber) {
                return lottoRank;
            }
        }
        throw new IllegalArgumentException("로또 매칭이 올바르지 않습니다");
    }

    public long sumPrize(int count) {
        return this.prizeMoney * count;
    }

}
