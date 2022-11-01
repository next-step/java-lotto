package lotto;

import java.util.Arrays;

public enum LottoResult {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchingCount;
    private final int prize;

    LottoResult(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoResult match(LottoTicket ticket, LottoTicket winningTicket) {
        int matchingCount = ticket.getMatchingCount(winningTicket);

        return Arrays.stream(values())
                .filter(result -> result.hasMatchingCount(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}
