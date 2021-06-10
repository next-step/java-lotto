package kr.aterilio.nextstep.techcamp.m1.lotto;

public class PrizeMoney {

    private static final int PRIZE_NONE = 0;

    private final int prize;

    public PrizeMoney(LottoResultDetail lottoResultDetail) {
        this.prize = calculatePrizeMoney(lottoResultDetail);
    }

    private int calculatePrizeMoney(LottoResultDetail lottoResultDetail) {
        int prizeMoney = PRIZE_NONE;
        for (ResultRank rank : ResultRank.values()) {
            int count = lottoResultDetail.of(rank);
            prizeMoney += rank.prize() * count;
        }
        return prizeMoney;
    }

    public int value() {
        return prize;
    }
}
