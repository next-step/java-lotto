package com.lotto;

import java.util.List;
import java.util.Map;

import static com.lotto.Message.*;

public class OutputView {

    static void out(String message) {
        System.out.println(message);
    }

    public static void requireLottoPrice() {
        out(REQUIRE_LOTTO_PRICE.message());
    }

    public static void confirmBuyCount(int buyCount) {
        out(buyCount + CONFIRM_BUY_COUNT.message());
    }

    public static void buyLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> out(lotto.numbers().toString()));
    }

    public static void requireWinningNumbers() {
        out(REQUIRE_WINNING_NUMBERS.message());
    }

    public static void winningStatistics() {
        out(WINNING_STATISTICS.message());
        out("---------");
    }

    public static void winningStatisticsDetail(Map<LottoReward, Integer> winningLottoMap) {
        for (LottoReward reward : winningLottoMap.keySet()) {
            String message = getMessage(reward);
            out(String.format(WINNING_STATISTICS_DETAIL.message(),
                    message, reward.reward(), winningLottoMap.get(reward)));
        }
    }

    public static void investment(double investment) {
        out(String.format(INVESTMENT.message(), investment));
    }

    private static String getMessage(LottoReward reward) {
        String message = "";

        switch (reward) {
            case THREE:
                message = "3";
                break;
            case FOUR:
                message = "4";
                break;
            case FIVE:
                message = "5";
                break;
            case SIX:
                message = "6";
                break;
        }
        return message;
    }
}
