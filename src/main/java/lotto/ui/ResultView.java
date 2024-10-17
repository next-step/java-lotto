package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.LottoRewardCountMap;
import lotto.domain.PurchasedLottos;

import java.util.List;

public class ResultView {
    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String DASH_LINE = "---------";
    private static final List<LottoReward> PRINT_TARGET_REWARDS = List.of(
            LottoReward.FIFTH_PLACE,
            LottoReward.FORTH_PLACE,
            LottoReward.THIRD_PLACE,
            LottoReward.SECOND_PLACE,
            LottoReward.FIRST_PLACE
    );

    public static void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        List<Lotto> purchasedLottoList = purchasedLottos.value();
        printPurchasedLottoNumbers(purchasedLottoList);
    }

    public static void printPurchasedLottosCount(int manualLottoCount, int automaticLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, automaticLottoCount);
    }

    private static void printPurchasedLottoNumbers(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
    }

    public static void printStatisticsSectionHeader() {
        addBlankLine();
        printStatisticsTitle();
        addDashLine();
    }

    private static void addBlankLine() {
        System.out.println();
    }

    private static void printStatisticsTitle() {
        System.out.println(LOTTO_STATISTICS_TITLE);
    }

    private static void addDashLine() {
        System.out.println(DASH_LINE);
    }

    public static void printRewardCountMap(LottoRewardCountMap rewardCountMap) {
        for (LottoReward reward : PRINT_TARGET_REWARDS) {
            System.out.printf("%s- %d개\n", reward.getDescription(), rewardCountMap.getRewardCount(reward));
        }
    }

    public static void printPercentageRateOfReturn(double percentageRateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.\n", percentageRateOfReturn);
    }
}
