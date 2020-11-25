package study.lotto.view.result;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;
import study.lotto.lottery.LotteryResult;
import study.lotto.view.AbstractView;

import java.util.Arrays;
import java.util.List;

public class LotteryResultView extends AbstractView {

    private LotteryResultView() {}

    private static final String LOTTERY_RESULT_MESSAGE = "당첨 통계";
    private static final String[] LOTTERY_STATISTIC_MESSAGES = { " (", ")- ", "개"};
    private static final String[] TOTAL_RETURN_RATIO_MESSAGES = {"총 수익률은 ", "입니다."};

    private static final List<LottoRank> lottoRanks
            = Arrays.asList(
                    LottoRank.FIFTH
                    , LottoRank.FOURTH
                    , LottoRank.THIRD
                    , LottoRank.SECOND
                    , LottoRank.FIRST);

    public static void display(LotteryResult lotteryResult) {

        stringBuilder.append(LOTTERY_RESULT_MESSAGE);
        printAndClear();

        stringBuilder.append("---------");
        printAndClear();

        printLotteryStatistic(lotteryResult);

        printTotalReturnRatio(lotteryResult);
    }

    private static void printLotteryStatistic(LotteryResult lotteryResult) {
        for (LottoRank lottoRank : lottoRanks) {

            stringBuilder.append(lottoRank.getDescription());
            stringBuilder.append(LOTTERY_STATISTIC_MESSAGES[0]);
            stringBuilder.append(lottoRank.getPrizeAmount());
            stringBuilder.append(LOTTERY_STATISTIC_MESSAGES[1]);
            stringBuilder.append(lotteryResult.getNumberOfLottoRank(lottoRank));
            stringBuilder.append(LOTTERY_STATISTIC_MESSAGES[2]);

            printAndClear();
        }
    }

    private static void printTotalReturnRatio(LotteryResult lotteryResult) {
        stringBuilder.append(TOTAL_RETURN_RATIO_MESSAGES[0]);
        stringBuilder.append(lotteryResult.getTotalReturnRatio());
        stringBuilder.append(TOTAL_RETURN_RATIO_MESSAGES[1]);

        printAndClear();
    }
}
