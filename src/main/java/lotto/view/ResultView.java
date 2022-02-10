package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.PrizeGrade;

public class ResultView {

    public static void printLottoNumbers(List<Lotto> lottoTicket) {
        lottoTicket.stream().forEach(item -> {
            OutputView.printLottoNumber(item);
            System.out.println();
        });
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        OutputView.printLottoStatisticTitle();

        printLottoStatistic(lottoStatistics);

        OutputView.printTotalReturn(Double.parseDouble(lottoStatistics.getLottoEarningRate()));
    }

    private static void printLottoStatistic(LottoStatistics lottoStatistics) {
        Arrays.stream(PrizeGrade.values()).forEach(prizeGrade -> {
            int prizeGradeCount = lottoStatistics.getResultStatistics().get(prizeGrade);

            printLottoStatus(prizeGrade, prizeGradeCount);
        });
    }

    private static void printLottoStatus(PrizeGrade prizeGrade, int prizeGradeCount) {
        OutputView.printLottoStatistic(prizeGrade, prizeGradeCount);
    }
}
