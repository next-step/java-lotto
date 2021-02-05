package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, "6개 일치", BigDecimal.valueOf(2_000_000_000L)),
    SECOND(5, "5개 일치, 보너스 볼 일치", BigDecimal.valueOf(30_000_000L)),
    THIRD(5, "5개 일치", BigDecimal.valueOf(1_500_000L)),
    FOURTH(4, "4개 일치", BigDecimal.valueOf(50_000L)),
    FIFTH(3, "3개 일치", BigDecimal.valueOf(5_000L)),
    NONE(null, "꽝", BigDecimal.valueOf(0L)),
    ;

    private static final Map<Integer, Rank> ranks = new HashMap<>();

    static {
        for (final Rank rank : values()) {
            ranks.put(rank.matchCount, rank);
        }
    }

    private final Integer matchCount;
    private final String matchCountMessage;
    private final BigDecimal amount;

    Rank(final Integer matchCount, final String matchCountMessage, final BigDecimal amount) {
        this.matchCount = matchCount;
        this.matchCountMessage = matchCountMessage;
        this.amount = amount;
    }

    /**
     * @param count             당첨 번호와 일치하는 번호의 개수
     * @param containsBonusBall 보너스 볼 일치 여부
     * @return 일치하는 번호의 개수에 따른 당첨 등급
     */
    public static Rank of(final int count, final boolean containsBonusBall) {
        if (count != 5) {
            return ranks.getOrDefault(count, NONE);
        }
        if (containsBonusBall) {
            return SECOND;
        }
        return THIRD;
    }

    public static List<Rank> getValuesAscendingOrder() {
        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> rank != NONE)
                .collect(Collectors.toList());
        Collections.reverse(ranks); // TODO: Rank 내 상수들의 선언 순서의 영향을 받으므로 수정 필요
        return ranks;
    }

    public BigDecimal getTotalPrizeByCount(final int count) {
        return this.amount.multiply(BigDecimal.valueOf(count));
    }

    @Override
    public String toString() {
        return matchCountMessage + " (" + amount + "원)- ";
    }
}