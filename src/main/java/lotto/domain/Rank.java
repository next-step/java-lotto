package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST(7, "6개 일치", 2000000000L),
    SECOND(6, "5개 일치, 보너스 볼 일치", 30000000L),
    THIRD(5, "5개 일치", 1500000L),
    FOURTH(4, "4개 일치", 50000L),
    FIFTH(3, "3개 일치", 5000L),
    NONE(0, "꽝", 0L),
    ;

    private static final Map<Integer, Rank> ranks = new HashMap<>();

    private final int matchCount;
    private final String matchCountMessage;
    private final long amount;

    static {
        for (final Rank rank : values()) {
            ranks.put(rank.matchCount, rank);
        }
    }

    Rank(final int matchCount, final String matchCountMessage, final long amount) {
        this.matchCount = matchCount;
        this.matchCountMessage = matchCountMessage;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    /**
     * @param count 당첨 번호와 일치하는 번호의 개수
     * @return 일치하는 번호의 개수에 따른 당첨 등급
     */
    public static Rank of(final int count) {
        return ranks.getOrDefault(count, NONE);
    }

    @Override
    public String toString() {
        return String.format("%s (%d원)-",matchCountMessage, amount);
    }
}