package study.lotto.step2.presentation;

import study.lotto.step2.domain.LottoResult;
import study.lotto.step2.domain.LottoResults;

import java.util.Arrays;

public class LottoResultsStatisticOutputView {
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---------";
    private static final String RATE_OF_RETURN = "총 수익률은 %s입니다.";
    private static final String WINNING_COUNT = "%d개 일치 (%d원)- %d개%n";
    private static final String WINNING_WITH_BONUS_COUNT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개%n";
    private final LottoResults lottoResults;

    public LottoResultsStatisticOutputView(LottoResults lottoResults) {
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
                .filter(this::isLottoWin)
                .forEach(this::printWinningCountOf);
    }

    private boolean isLottoWin(LottoResult lottoResult) {
        return !lottoResult.equals(LottoResult.NOT_WIN);
    }

    private void printRateOfReturn() {
        System.out.printf(RATE_OF_RETURN, lottoResults.rateOfReturn());
    }

    private void printWinningCountOf(LottoResult lottoResult) {
        if(lottoResult.equals(LottoResult.MATCH_FIVE_NUMBERS_WITH_BONUS)) {
            printWinningCountOf(WINNING_WITH_BONUS_COUNT, lottoResult);
            return;
        }

        printWinningCountOf(WINNING_COUNT, lottoResult);
    }

    private void printWinningCountOf(String printMessage, LottoResult lottoResult) {
        System.out.printf(printMessage, lottoResult.numberOfMatches(), lottoResult.payout(), lottoResults.countOf(lottoResult));
    }

    private void consoleLineBreak() {
        System.out.println();
    }
}
