package lotto.view;

import lotto.domain.lotto.Lottos;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.MatchResult;

import java.util.stream.Collectors;

public class ResultView {
    private static final String BUY_RESULT_STATEMENT_FORMAT = "%d 개를 구매했습니다.";
    private static final String WINNING_PRIZE_STATISTICS_STATEMENT = "당첨 통계" + System.lineSeparator() + "----------";
    private static final String PRIZE_RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
    }

    public static void printLottos(Lottos lottos) {
        printStatement(String.format(BUY_RESULT_STATEMENT_FORMAT, lottos.size()));

        lottos.getLottos().stream()
                .map(ResultView::makeLottoNumberResult)
                .forEach(ResultView::printStatement);

    }

    private static String makeLottoNumberResult(lotto.domain.lotto.Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[ ", " ]"));
    }

    public static void printMatchResult(MatchResult matchResult) {
        printStatement(WINNING_PRIZE_STATISTICS_STATEMENT);

        LottoPrize.getWinningPrizes()
                .forEach(lottoPrize -> printPrizeResult(lottoPrize, matchResult));

        printStatement(String.format(EARNINGS_RATE_FORMAT, matchResult.calculateEarningsRate()));
    }

    private static void printPrizeResult(LottoPrize lottoPrize, MatchResult matchResult) {
        String result = String.format(
                PRIZE_RESULT_FORMAT,
                lottoPrize.getMatchCount(),
                lottoPrize.getPrizeMoneyAmount(),
                matchResult.matchCount(lottoPrize)
        );

        printStatement(result);
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }
}
