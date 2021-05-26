package com.lotto.ui;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoReward;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.ReqPurchaseLotto;

import java.util.List;

import static com.lotto.domain.LottoReward.MISS;
import static com.lotto.domain.LottoReward.SECOND_BONUS;
import static com.lotto.ui.Message.*;

public class OutputView {

    public static void out(String message) {
        System.out.println(message);
    }

    public static void requireLottoPrice() {
        out(REQUIRE_LOTTO_PRICE.message());
    }

    public static void confirmBuyCount(ReqPurchaseLotto reqPurchaseLotto) {
        out(String.format(CONFIRM_BUY_COUNT.message(),
                reqPurchaseLotto.getManualLottoCount(), reqPurchaseLotto.getAutoLottoCount()));
    }

    public static void buyLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> out(lotto.numbers().toString()));
    }

    public static void requireWinningNumbers() {
        out(REQUIRE_WINNING_NUMBERS.message());
    }

    public static void requireBonusNumbers() {
        out(REQUIRE_BONUS_NUMBER.message());
    }

    public static void requireManualLottoCount() { out(REQUIRE_MANUAL_LOTTO_COUNT.message()); }

    public static void requireManualNumberList() { out(REQUIRE_MANUAL_NUMBER.message()); }

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
        if (reward != MISS) {
            out(String.format(WINNING_STATISTICS_DETAIL.message(),
                    reward.sameCount(), reward == SECOND_BONUS ? WINNING_BONUS.message() : "",
                    reward.reward(), lottoStatistics.get(reward)));
        }
    }

    public static void investment(double investment) {
        out(String.format(INVESTMENT.message(), investment));
    }
}
