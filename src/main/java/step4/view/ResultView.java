package step4.view;

import step4.domain.lotto.LottoMatch;
import step4.domain.lotto.Lottos;
import step4.domain.lotto.Profit;

public class ResultView {

    private ResultView() {
    }

    public static void printCount(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.numbers().toString()));
    }

    public static void printLottoStatistics(LottoMatch lottoMatch, Profit profit) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        printLottoStatistics(lottoMatch);
        printLottoProfit(profit);
    }

    private static void printLottoProfit(Profit profit) {
        System.out.println("총 수익률은 " + profit.getProfit() + "% 입니다.");
    }

    private static void printLottoStatistics(LottoMatch resultOfLottos) {
        resultOfLottos.getLottoMatch().forEach((lottoMatch, integer) ->
            System.out.printf("%d개 일치 (%d 원) - %d개 \n", lottoMatch.getNumber(), lottoMatch.getWinMoney(), resultOfLottos.winCount(lottoMatch)));
    }

}
