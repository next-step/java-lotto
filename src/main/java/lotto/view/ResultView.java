package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoProfitCalculator;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.List;

public class ResultView {

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto: lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d) - %d개\n", Prize.THREE.getValue(), result.getOrZero(Prize.THREE));
        System.out.printf("4개 일치 (%d) - %d개\n", Prize.FOUR.getValue(), result.getOrZero(Prize.FOUR));
        System.out.printf("5개 일치 (%d) - %d개\n", Prize.FIVE.getValue(), result.getOrZero(Prize.FIVE));
        System.out.printf("5개 일치, 보너스 볼 일치 (%d) - %d개\n", Prize.FIVE_BONUS.getValue(), result.getOrZero(Prize.FIVE_BONUS));
        System.out.printf("6개 일치 (%d) - %d개\n", Prize.SIX.getValue(), result.getOrZero(Prize.SIX));
    }

    public static void printProfit(int price, LottoResult result) {
        float profit = new LottoProfitCalculator().calculate(price, result);

        System.out.printf("총 수익률은 %.2f입니다.", profit);
        if (profit > 1) {
            System.out.println(" (이득을 봤습니다.)");
        }
        if (profit == 1) {
            System.out.println(" (본전입니다.)");
        }
        if (profit < 1) {
            System.out.println(" (기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
