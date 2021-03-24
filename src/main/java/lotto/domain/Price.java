/*
* 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
* */
package lotto.domain;

import java.util.stream.IntStream;

public class Price {
    public static final int LOTTO_PRICE = 1000;
    private static Long NO_MATCH = 0L;
    public static final Long THREE_MATCH_PRICE = 5000L;
    public static final Long FOUR_MATCH_PRICE = 50000L;
    public static final Long FIVE_MATCH_PRICE = 1500000L;
    public static final Long SIX_MATCH_PRICE = 2000000000L;

    private static Long[] prices = {NO_MATCH, NO_MATCH, NO_MATCH, THREE_MATCH_PRICE, FOUR_MATCH_PRICE, FIVE_MATCH_PRICE, SIX_MATCH_PRICE};

    public static Long calculate(int[] match) {
        return IntStream.range(0, match.length)
                .mapToLong(i -> {
                    return match[i] * prices[i];
                })
                .sum();
    }

    public static Long winningPrice(int index) {
        return prices[index];
    }

}
