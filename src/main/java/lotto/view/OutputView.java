package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.dto.Summary;

import java.util.List;

public class OutputView {


    public static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장 자동으로 %d개를 구매했습니다.";
    public static final String SUMMARY_WINNING_MESSAGE = "%s - %s개";
    public static final String SUMMARY_WINNING_SECOND_MESSAGE = "%s, 보너스 볼 일치 - %s개";

    public static final String SUMMARY_HEAD = "당첨 통계";
    public static final String SEPARATOR_LINE = "------------------------";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %f입니다.";


    public void printLottoCount(int manual, int auto) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", manual, auto);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printNumbers(lotto);
        }
        System.out.println();
    }

    private void printNumbers(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printSummary(Summary summary) {
        System.out.println();
        System.out.println(SUMMARY_HEAD);
        System.out.println(SEPARATOR_LINE);
        System.out.println(summary);
    }
}
