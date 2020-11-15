package study.lotto.view.result;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;
import study.lotto.lottery.LotteryResult;
import study.lotto.view.AbstractView;

import java.util.Arrays;
import java.util.List;

public class LotteryResultView extends AbstractView {

    private static final LotteryResultView instance = new LotteryResultView();

    private static final List<LottoRank> lottoRanks
            = Arrays.asList(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    public static LotteryResultView getInstance() {
        return instance;
    }

    public void display(LotteryResult lotteryResult) {

        stringBuilder.append("당첨 통계");
        printAndClear();

        stringBuilder.append("---------");
        printAndClear();

        printLotteryStatistic(lotteryResult);

        printTotalReturnRatio(lotteryResult);
    }

    private void printLotteryStatistic(LotteryResult lotteryResult) {
        for (LottoRank lottoRank : lottoRanks) {

            List<Lotto> lottos = lotteryResult.getLottoRankOf(lottoRank);

            stringBuilder.append(lottoRank.getMatchingNumberCount());
            stringBuilder.append("개 일치 (");
            stringBuilder.append(lottoRank.getPrizeAmount());
            stringBuilder.append(")- ");
            stringBuilder.append(lottos.size());
            stringBuilder.append("개");

            printAndClear();
        }
    }

    private void printTotalReturnRatio(LotteryResult lotteryResult) {
        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(lotteryResult.getTotalReturnRatio());
        stringBuilder.append("입니다.");

        printAndClear();
    }
}
