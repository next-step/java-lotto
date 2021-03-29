package lotto.view;

import lotto.util.LottoCountDto;
import lotto.util.LottosDto;
import lotto.domain.Money;
import lotto.domain.ResultGroup;

import java.util.List;

public class ResultView {

    private static final double PROFIT_BOUNDARY = 1.0d;

    private ResultView() {
    }

    public static void showResult(ResultGroup result, Money money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(result.showResult());
        double rates = result.getRates(money);
        System.out.println("총 수익률은 " + rates + "입니다." + showProfit(rates));
    }

    private static String showProfit(double rates) {
        if (rates <= PROFIT_BOUNDARY) {
            return " 손해입니다.";
        }
        return " 이익입니다.";
    }

    public static void showCount(LottoCountDto lottoCount) {
        System.out.println(String.format("수동 %d개, 자동 %d개를 구매했습니다", lottoCount.getManualCount(), lottoCount.getAutoCount()));
    }

    public static void showLottos(LottosDto lottos) {
        List<String> lottoResult = lottos.getLottos();
        for (String result : lottoResult) {
            System.out.println(String.format("[%s]", result));
        }
        System.out.println();
    }
}
