/*
 * 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
 * */
package lotto.domain;

import java.util.Arrays;
import java.util.stream.IntStream;

public enum Rank {
    NO_MATCH(0, 0L),
    THREE_MATCH_PRICE(3, 5000L),
    FOUR_MATCH_PRICE(4, 50_000L),
    FIVE_MATCH_PRICE(5, 1_500_000L),
    SIX_MATCH_PRICE(6, 2_000_000_000L);

    public static final int LOTTO_PRICE = 1000;
    private static Rank[] prices = {NO_MATCH, NO_MATCH, NO_MATCH, THREE_MATCH_PRICE, FOUR_MATCH_PRICE, FIVE_MATCH_PRICE, SIX_MATCH_PRICE};

    private final int matchNo;
    private final Long winningMoney;

    Rank(int matchNo, Long winningMoney) {
        this.matchNo = matchNo;
        this.winningMoney = winningMoney;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public static Long calculate(int[] match) {
        return IntStream.range(0, match.length)
                .mapToLong(i -> {
                    return match[i] * prices[i].winningMoney;
                })
                .sum();
    }

    public static Rank matchRank(int matchNum) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchNo == matchNum)
                .findFirst()
                .orElse(NO_MATCH);
    }

}
