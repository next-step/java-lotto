package ui;

import application.LottoGameResult;
import view.LottoView;
import view.OutputResultView;

import java.util.List;

public class Console {

    private static final String PURCHASE_COMMENT = "를 구매했습니다.";
    private static final String RESULT_TOP_COMMENT = "당첨 통계";
    private static final String RESULT_VALUE_COMMENT = "%d개 일치 (%d원) - %d개";
    private static final String RESULT_PROFIT_COMMENT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void showPurchase(int count) {
        System.out.println(count + PURCHASE_COMMENT);
    }

    public static void showLottoNumber(List<LottoView> buyedLottos) {
        buyedLottos.stream().forEach(v -> System.out.println(v.getNumbers()));
    }

    public static void showResult(OutputResultView view) {
        System.out.println(RESULT_TOP_COMMENT);
        printResult(view, 3);
        printResult(view, 4);
        printResult(view, 5);
        printResult(view, 6);
        emptyLine();
        System.out.printf(RESULT_PROFIT_COMMENT, view.getProfit());
    }

    private static void printResult(OutputResultView view, int matchCount) {
        System.out.printf(RESULT_VALUE_COMMENT,
                LottoGameResult.match(matchCount).getValue(),
                LottoGameResult.match(matchCount).getReward(),
                view.getLottoMatchCounts().get(matchCount));
        emptyLine();

    }

    private static void emptyLine() {
        System.out.println();
    }
}
