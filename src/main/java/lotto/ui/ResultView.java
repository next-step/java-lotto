package lotto.ui;

import lotto.domain.LottoWinningResult;
import lotto.domain.LottoWinningResults;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String HEADER_END = "---------";
    private static final String PROFIT_RATE_SUFFIX = "입니다.";
    private static final String PROFIT_RATE_LESS_THAN_ONE_SUFFIX = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String PROFIT_RATE_PREFIX = "총 수익률은 ";

    private ResultView() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static void printLottoDetail(final List<List<Integer>> ticket) {
        ticket.forEach(lotto ->
                System.out.println(Arrays.toString(lotto.toArray())));
    }

    public static void printWinningStatistics(final LottoWinningResults lottoWinningResults) {
        printEmptyLine();
        printHeader();
        printLottoWinningResult(lottoWinningResults);
    }

    private static void printLottoWinningResult(final LottoWinningResults lottoWinningResults) {
        for (LottoWinningResult lottoWinningResult : lottoWinningResults.getWinningResults()) {
            System.out.println(
                    lottoWinningResult.getLottoWinningStatus().getWinningCount()
                            + "개 일치 ("
                            + lottoWinningResult.getLottoWinningStatus().getAmount()
                            + "원)- "
                            + lottoWinningResult.getCount()
                            + "개"
            );
        }
    }

    public static void printProfitRate(final int totalPurchasePrice, final LottoWinningResults lottoWinningResults) {
        double result = lottoWinningResults.getProfitRate(totalPurchasePrice);
        String suffix = result < 1 ? PROFIT_RATE_SUFFIX+PROFIT_RATE_LESS_THAN_ONE_SUFFIX : PROFIT_RATE_SUFFIX;
        System.out.println(PROFIT_RATE_PREFIX + result + suffix);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printHeader() {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(HEADER_END);
    }
}
