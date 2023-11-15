package lotto.domain;

public enum LottoRank {
    MISS(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int count;
    private final long prizeMoney;

    LottoRank(int count, long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findMatchCount(int matchNumber, boolean bouns) {
        if (matchNumber == 5 && bouns) {
            return LottoRank.SECOND;
        }

        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.count == matchNumber) {
                return lottoRank;
            }
        }

        throw new IllegalArgumentException("로또 매치가 올바르지 않습니다");
    }
    
    public long sumPrize(int count) {
        return this.prizeMoney * count;
    }

    public int count() {
        return this.count;
    }

    public long prize() {
        return this.prizeMoney;
    }
}
