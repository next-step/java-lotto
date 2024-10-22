package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.LottoResult;
import lotto.domain.LottoRewards;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String LOTTO_REWARD = "%d개 일치 (%d원)- %d개";
    private static final String SECOND_REWARD = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String LOTTO_PROFIT_LOSS = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_PROFIT_NOTHING = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    private static final String LOTTO_PROFIT_BENEFIT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final int BENEFIT_STANDARD = 1;

    public static void printLottos(final Lottos lottos, final LottoPurchaseInfo lottoPurchaseInfo) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoPurchaseInfo.getManualCount(), lottoPurchaseInfo.calculateAutoCount());
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .collect(Collectors.toList()));
        }
        System.out.println();
    }

    public static void printLottoStatistics(final LottoResult lottoResult, final LottoPurchaseInfo lottoPurchaseInfo) {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.println(LINE);

        printLottoRewards(lottoResult);
        printLottoProfit(lottoResult.calculateProfit(lottoPurchaseInfo));
    }

    private static void printLottoRewards(final LottoResult lottoResult) {
        Map<LottoRewards, Integer> rewardsMap = lottoResult.getResultMap();
        List<LottoRewards> lottoRewards = Arrays.asList(LottoRewards.values());

        for (LottoRewards lottoReward : lottoRewards) {
            printLottoReward(lottoReward, rewardsMap.get(lottoReward));
        }
    }

    private static void printLottoReward(final LottoRewards lottoReward, final int matchCount) {
        if (lottoReward.equals(LottoRewards.NONE)) {
            return;
        }
        if (lottoReward.equals(LottoRewards.SECOND)) {
            System.out.printf(SECOND_REWARD, lottoReward.getMatchCount(), lottoReward.getPrize(), matchCount);
            System.out.println();
        }
        System.out.printf(LOTTO_REWARD, lottoReward.getMatchCount(), lottoReward.getPrize(), matchCount);
        System.out.println();
    }

    private static void printLottoProfit(final double profit) {
        if (profit > BENEFIT_STANDARD) {
            System.out.printf(LOTTO_PROFIT_BENEFIT, profit);
            return;
        }
        if (profit < BENEFIT_STANDARD) {
            System.out.printf(LOTTO_PROFIT_LOSS, profit);
            return;
        }
        System.out.printf(LOTTO_PROFIT_NOTHING, profit);
    }
}
