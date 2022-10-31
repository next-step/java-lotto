package lotto;

import java.util.Arrays;

public enum LottoResult {
    NONE(0),
    FOURTH(3),
    THIRD(4),
    SECOND(5),
    FIRST(6);

    private final int matchingCount;

    LottoResult(int matchingCount) {
        this.matchingCount = matchingCount;
    }

    public static LottoResult match(LottoTicket ticket, LottoTicket winningTicket) {
        int matchingCount = ticket.getMatchingCount(winningTicket);

        return Arrays.stream(values())
                .filter(winnerClass -> winnerClass.hasMatchingCount(matchingCount))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean hasMatchingCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }
}
