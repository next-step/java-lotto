package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.ResultGroupDto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningResult;

public class OutputView {

    private static final String LOTTO_COUNT_PRINT_FORMAT = "%d개를 구매했습니다\n";
    private static final String LOTTO_PRINT_FORMAT = "[%s]\n";
    private static final String LOTTO_DELIMITER = ", ";
    private static final String STATICS_RESULT_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %.2f입니다";
    private static final String PROFIT_WARNING_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final double PROFIT_THRESHOLD = 1.0;


    private OutputView() {
    }

    public static void printLottoCount(int count) {
        System.out.printf(LOTTO_COUNT_PRINT_FORMAT, count);
    }

    public static void printEachLotto(List<LottoNumber> values) {
        String lotto = values.stream()
            .map(LottoNumber::value)
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_DELIMITER));
        System.out.printf(LOTTO_PRINT_FORMAT, lotto);
    }

    public static void printResult(ResultGroupDto resultGroup) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (WinningResult result : WinningResult.winningResults()) {
            int count = resultGroup.howManyHave(result);
            System.out.printf(STATICS_RESULT_FORMAT, result.count(), result.prize(), count);
        }
        System.out.printf(PROFIT_RESULT_FORMAT, resultGroup.getProfits());
        if (resultGroup.getProfits() < PROFIT_THRESHOLD) {
            System.out.println(PROFIT_WARNING_MESSAGE);
        }
    }
}
