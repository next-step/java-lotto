package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NOTHING(0, 0),
    THREE_SAME(5000, 3),
    FOUR_SAME(50000, 4),
    FIVE_SAME(1500000, 5),
    SIX_SAME(2000000000, 6),
    ;

    private final long prizeMoney;
    private final long sameCount;

    LottoRank(int prizeMoney, int sameCount) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
    }

    public static LottoRank of(LottoTicket myTicket, LottoTicket winnerTicket) {
        long count = myTicket.sameCount(winnerTicket);
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.isSameCount(count))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isSameCount(long sameCount) {
        return this.sameCount == sameCount;
    }

    public long prizeMoney() {
        return prizeMoney;
    }
}
