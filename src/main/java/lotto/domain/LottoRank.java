package lotto.domain;

public enum LottoRank {
    BLANK(0, 0)
    , FOURTH(4, 5_000)
    , THIRD(3, 50_000)
    , SECOND(2, 1_500_000)
    , FIRST(1, 2_000_000_000)
    ;

    private int rank;
    private int prizeMoney;

    LottoRank(final int rank, final int prizeMoney) {
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }
}
