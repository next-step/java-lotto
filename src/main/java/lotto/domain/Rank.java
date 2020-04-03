package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, Money.of(5000)),
    FOURTH(4, Money.of(50000)),
    THIRD(5, Money.of(1500000)),
    SECOND(5, Money.of(30000000)),
    FIRST(6, Money.of(2000000000));

    private int matchCount;
    private Money reward;

    Rank(int matchCount, Money reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank of(LottoTicketResult lottoTicketResult) {
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

    public Money getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
