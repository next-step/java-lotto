package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private long amount;

    Rank(int matchCount, long amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank findByLottoTicketResult(LottoTicketResult lottoTicketResult) {
        int matchCount = lottoTicketResult.getMatchCount();
        boolean bonusMatch = lottoTicketResult.isBonusMatch();

        if (matchCount == SECOND.getMatchCount() && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(s -> s.matchCount == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("당첨 되지 않았습니다."));
    }

    public long getAmount() {
        return amount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
