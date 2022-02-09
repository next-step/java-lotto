package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.controller.ResultGroupDto;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningResult;

public class OutputView {

    private static final String LOTTO_COUNT_PRINT_FORMAT = "%d개를 구매했습니다\n";
    private static final String LOTTO_PRINT_FORMAT = "[%s]\n";
    private static final String STATICS_RESULT_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %.2f입니다";
    private static final double PROFIT_THRESHOLD = 1.0;

    private OutputView() {
    }

    public static void printLottoCount(int count) {
        System.out.printf(LOTTO_COUNT_PRINT_FORMAT, count);
    }

    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.printf(LOTTO_PRINT_FORMAT,
                lotto.value()
                    .stream()
                    .map(LottoNumber::value)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))
            );
        }
    }

    public static void printResult(ResultGroupDto resultGroup) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (WinningResult result : WinningResult.winningResults()) {
            int count = resultGroup.getResultGroup().howManyHave(result);
            System.out.printf(STATICS_RESULT_FORMAT, result.count(), result.prize(), count);
        }
        System.out.printf(PROFIT_RESULT_FORMAT, resultGroup.getResultGroup().getProfits(resultGroup.getMoney()));
        if (resultGroup.getResultGroup().getProfits(resultGroup.getMoney()) < PROFIT_THRESHOLD) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
