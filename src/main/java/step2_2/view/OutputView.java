package step2_2.view;

import static java.lang.String.format;

import java.util.Map;
import step2_2.domain.LottoBundle;
import step2_2.domain.LottoResult;
import step2_2.domain.LottoReward;

public class OutputView {

    private static final String RESULT_PRINT_MESSAGE = "당첨 통계";
    private static final String LINE = "------------";
    private static final String WINNER_PRINT_FORMAT = "%d개 일치 (%s원)- %d개\n";
    private static final String YIELD_PRINT_FORMAT = "총 수익률은 %.2f입니다\n";
    private static final int MATCH_COUNT_MIN = 3;
    private static final int MATCH_COUNT_MAX = 6;

    private OutputView() {
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        System.out.println(lottoBundle.getLottoCount() + "개를 구입하셨습니다");
        System.out.println(lottoBundle);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(RESULT_PRINT_MESSAGE);
        System.out.println(LINE);
        printRewardMap(lottoResult.getRewardMap());
        printYield(lottoResult);
    }

    private static void printRewardMap(Map<LottoReward, Long> rewardMap) {
        for (int matchCount = MATCH_COUNT_MIN; matchCount <= MATCH_COUNT_MAX; matchCount++) {
            LottoReward lottoReward = LottoReward.fromMatchCount(matchCount);
            printReward(lottoReward, rewardMap.get(lottoReward));
        }
    }

    private static void printReward(LottoReward lottoReward, Long winnerCount) {
        System.out.print(format(WINNER_PRINT_FORMAT, lottoReward.getMatchCount(), lottoReward.getReward(), winnerCount));
    }

    private static void printYield(LottoResult lottoResult) {
        System.out.printf(YIELD_PRINT_FORMAT, lottoResult.getYield());
    }
}
