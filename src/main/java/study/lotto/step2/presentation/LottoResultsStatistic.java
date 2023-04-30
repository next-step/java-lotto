package study.lotto.step2.presentation;

import study.lotto.step2.domain.LottoResult;
import study.lotto.step2.domain.LottoResults;

import java.util.Arrays;

public class LottoResultsStatistic {
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---------";
    private final LottoResults lottoResults;

    public LottoResultsStatistic(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public void printWinningStatistic() {
        consoleLineBreak();
        System.out.println(WINNING_STATISTIC);
        System.out.println(HORIZONTAL_LINE);

        printWinningCount();
        printRateOfReturn();
    }

    private void printWinningCount() {
        Arrays.stream(LottoResult.values())
                .filter(LottoResult::isWinning)
                .forEach(this::printWinningCountOf);
    }

    private void printRateOfReturn() {
        System.out.printf("총 수익률은 %s입니다.", lottoResults.rateOfReturn());
    }

    private void printWinningCountOf(LottoResult lottoResult) {
        System.out.printf("%d개 일치 (%d원)- %d개%n",
                lottoResult.numberOfMatches(), lottoResult.payout(), lottoResults.countOf(lottoResult));
    }

    private void consoleLineBreak() {
        System.out.println();
    }
}
