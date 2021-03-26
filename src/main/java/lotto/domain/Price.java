/*
 * 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
 * */
package lotto.domain;

import java.util.stream.IntStream;

public enum Price {

    THREE_MATCH_PRICE(5000L),
    FOUR_MATCH_PRICE(50_000L),
    FIVE_MATCH_PRICE(1_500_000L),
    SIX_MATCH_PRICE(2_000_000_000L),
    NO_MATCH(0L);

    public static final int LOTTO_PRICE = 1000;
    private static Price[] prices = {NO_MATCH, NO_MATCH, NO_MATCH, THREE_MATCH_PRICE, FOUR_MATCH_PRICE, FIVE_MATCH_PRICE, SIX_MATCH_PRICE};

    private Long price;

    Price(Long price) {
        this.price = price;
    }


    public static Long calculate(int[] match) {
        return IntStream.range(0, match.length)
                .mapToLong(i -> {
                    return match[i] * prices[i].price;
                })
                .sum();
    }

    public static Long winningPrice(int matchNum) {
        return prices[matchNum].price;
    }

}
