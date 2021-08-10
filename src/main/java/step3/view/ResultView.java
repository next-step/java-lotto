package step3.view;

import step3.domain.lotto.LottoMatch;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.Profit;

public class ResultView {

    private ResultView() {
    }

    public static void printCount(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
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
        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private static void printLottoStatistics(LottoMatch resultOfLottos) {
        resultOfLottos.getLottoMatch().forEach((lottoMatch, integer) ->
            System.out.println(lottoMatch.getNumber() + "개 일치 ("
                + lottoMatch.getWinMoney() + " 원) - "
                + resultOfLottos.winCount(lottoMatch) + "개"));
    }

}
