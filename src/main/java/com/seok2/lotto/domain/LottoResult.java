package com.seok2.lotto.domain;

import static com.seok2.common.utils.StringUtils.LINE_BREAK;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class LottoResult {

    private static final List<Rank> RANK_LIST = Arrays
        .asList(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    private static final String RESULT_TITLE = "당첨 통계 \n----------------------";
    private static final String RANK_MSG = "{0} - {1} 개";
    private static final String YIELD_MSG = "총 수익률은 {0}입니다.";

    private final Money purchaseAmount;
    private final Ranks ranks;

    private LottoResult(Money purchaseAmount, Ranks ranks) {
        this.purchaseAmount = purchaseAmount;
        this.ranks = ranks;
    }

    public static LottoResult of(Money purchaseAmount, Ranks ranks) {
        return new LottoResult(purchaseAmount, ranks);
    }

    private double calculateYield() {
        return ranks.getTotalReward().percent(purchaseAmount);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(RESULT_TITLE)
            .append(LINE_BREAK);
        for (Rank rank : RANK_LIST) {
            builder
                .append(MessageFormat.format(RANK_MSG, rank, ranks.count(rank)))
                .append(LINE_BREAK);
        }
        builder.append(MessageFormat.format(YIELD_MSG, calculateYield()));
        return builder.toString();
    }

}
