package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoReward;
import lotto.domain.Lottos;

public class ResultView {
    private static final String PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String LINE_SEPARATOR = "---------";
    private static final String REWARD_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public ResultView() {
    }

    public static void printPurchaseLottoCount(final Lottos lottos) {
        System.out.println(lottos.getLottos().size() + PRINT_PURCHASE_LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .collect(Collectors.toList()));
        }
        System.out.println();
    }

    public static void printWinningStatistics(Map<LottoReward,Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE_SEPARATOR);

        List<LottoReward> lottoRewards = Arrays.asList(LottoReward.values());
        Collections.reverse(lottoRewards);

        for (LottoReward reward : lottoRewards) {
            printRewordMessage(reward,lottoResult.get(reward));
        }
    }

    private static void printRewordMessage(LottoReward lottoReward, int matchCount) {
        if (lottoReward.equals(LottoReward.NONE)) {
            return;
        }
        System.out.printf(REWARD_MESSAGE, lottoReward.getMatchCount(), lottoReward.getPrize(), matchCount);
        System.out.println();
    }

    public static void printLottoProfit(double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }
}
