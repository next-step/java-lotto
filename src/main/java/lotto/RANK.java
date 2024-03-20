package lotto;


/**
 *  3개 일치 (5000원)- 1개
 *  4개 일치 (50000원)- 0개
 *  5개 일치 (1500000원)- 0개
 *  6개 일치 (2000000000원)- 0개
 *  수익률 = 총 당첨 금액 / 구입 금액
 *  */
public enum RANK {

    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000);

    private final long prizeMoney;

    RANK(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public long winPrize(Integer count) {
        return this.prizeMoney * count;
    }
}
