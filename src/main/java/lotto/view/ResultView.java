package lotto.view;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoBunch;

import java.util.stream.Collectors;

public class ResultView {
    private static final String BUY_RESULT_STATEMENT_FORMAT = "%d 개를 구매했습니다.";
    private static final String WINNING_PRIZE_STATISTICS_STATEMENT = "당첨 통계" + System.lineSeparator() + "----------";
    private static final String PRIZE_RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {}

    public static void printLottos(LottoBunch lottoBunch) {
        printStatement(String.format(BUY_RESULT_STATEMENT_FORMAT, lottoBunch.getAllLottoCount()));

        lottoBunch.getLottos().stream()
                .map(v -> v.getLottoNumbers().stream()
                        .map(LottoNumber::getNumberString)
                        .collect(Collectors.joining(", ", "[ ", " ]"))
                )
                .forEach(ResultView::printStatement);

    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }
}
