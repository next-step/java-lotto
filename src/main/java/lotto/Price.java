/*
* 당첨 가격과 당첨 개수에 따른 당첨금액을 계산하는 클래스
* */
package lotto;

import java.util.Arrays;

public class Price {
    private static int NO_MATCH = 0;
    public static final int THREE_MATCH_PRICE = 5000;
    public static final int FOUR_MATCH_PRICE = 50000;
    public static final int FIVE_MATCH_PRICE = 1500000;
    public static final int SIX_MATCH_PRICE = 2000000000;

    private static int[] prices = {NO_MATCH, NO_MATCH, NO_MATCH, THREE_MATCH_PRICE, FOUR_MATCH_PRICE, FIVE_MATCH_PRICE, SIX_MATCH_PRICE};

    public static int calculate(int[] match) {
        return Arrays.stream(match)
                .map(num -> {
                    return num * prices[num];
                })
                .sum();
    }

}
