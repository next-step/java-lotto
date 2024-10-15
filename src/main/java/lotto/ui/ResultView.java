package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoReward;
import lotto.domain.PurchasedLottos;

import java.util.List;
import java.util.Map;

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
        printPurchasedLottosCount(purchasedLottoList);
        printPurchasedLottoNumbers(purchasedLottoList);
    }

    private static void printPurchasedLottosCount(List<Lotto> purchasedLottos) {
        System.out.printf("%d개를 구입했습니다.\n", purchasedLottos.size());
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

    public static void printRewardCountMap(Map<LottoReward, Integer> rewardCountMap) {
        for (LottoReward reward : PRINT_TARGET_REWARDS) {
            System.out.printf("%s- %d개\n", reward.getDescription(), rewardCountMap.getOrDefault(reward, 0));
        }
    }

    public static void printPercentageRateOfReturn(double percentageRateOfReturn) {
        System.out.printf("총 수익률은 %.2f입니다.\n", percentageRateOfReturn);
    }
}
