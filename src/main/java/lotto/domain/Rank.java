package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST(7, "6개 일치", "2000000000원"),
    SECOND(6, "5개 일치, 보너스 볼 일치", "30000000원"),
    THIRD(5, "5개 일치", "1500000원"),
    FOURTH(4, "4개 일치", "50000원"),
    FIFTH(3, "3개 일치", "5000원"),
    NONE(0, "꽝", "0원"),
    ;

    private static final Map<Integer, Rank> ranks = new HashMap<>();

    private final int matchCount;
    private final String matchCountMessage;
    private final String amount;

    static {
        for (final Rank rank : values()) {
            ranks.put(rank.matchCount, rank);
        }
    }

    Rank(final int matchCount, final String matchCountMessage, final String amount) {
        this.matchCount = matchCount;
        this.matchCountMessage = matchCountMessage;
        this.amount = amount;
    }

    /**
     * @param count 당첨 번호와 일치하는 번호의 개수
     * @return 일치하는 번호의 개수에 따른 당첨 등급
     */
    public static Rank of(final int count) {
        return ranks.getOrDefault(count, NONE);
    }
}