package com.lotto.ui;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoReward;
import com.lotto.domain.LottoStatistics;

import java.util.List;

import static com.lotto.domain.LottoReward.NOTHING;
import static com.lotto.ui.Message.*;

public class OutputView {

    public static void out(String message) {
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

    public static void winningStatisticsDetail(LottoStatistics lottoStatistics) {
        for (LottoReward reward : LottoReward.values()) {
            printOnlyWinningLotto(lottoStatistics, reward);
        }
    }

    private static void printOnlyWinningLotto(LottoStatistics lottoStatistics, LottoReward reward) {
        if (reward != NOTHING) {
            out(String.format(WINNING_STATISTICS_DETAIL.message(),
                    reward.toString(), reward.reward(), lottoStatistics.get(reward)));
        }
    }

    public static void investment(double investment) {
        out(String.format(INVESTMENT.message(), investment));
    }
}
