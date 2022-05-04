package autolotto.view;

import autolotto.domain.Lottos;
import autolotto.domain.Results;

public class LottoOutput {
    public void println(String printable) {
        System.out.println(printable);
    }

    public void printResult(Results results) {
        println("당첨통계");
        println("----------------");

//        for (Result result : results.getResults()) {
//            long prize = Rank.find(result.getCountOfMatch(), result.hasBonusBall()).getWinningMoney();
//
//            String outputFormat = "%s개 일치 (%d원) - %s개";
//            if (result.hasBonusBall()) {
//                outputFormat = "%s개 일치, 보너스 볼 일치 (%d원) - %s개";
//            }
//            println(String.format(outputFormat, result.getCountOfMatch(), prize, result.getWinners()));
//        }
    }

    public void printProfit(Lottos lottos, Results results) {
//        System.out.printf("총 수익률은 %.0f%%입니다. (100%%가 구매한 금액만큼 돈이 당첨된 것.) %n", (double) results.prize() / lottos.cost() * 100);
    }

    public void printQuantity(int lottoQuantity) {
        println(lottoQuantity + "장을 구입했습니다.");
    }
}
