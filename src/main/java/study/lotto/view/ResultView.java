package study.lotto.view;

import study.lotto.model.LottoList;
import study.lotto.model.LottoRank;
import study.lotto.model.Statistics;

public class ResultView {

    public static void printPurchaseMessage(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    public static void printLottoList(LottoList lottoList) {
        lottoList.getLottoList()
                .forEach(System.out::println);
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        LottoRank.getLottoRanksOverMinimumMatches()
                .forEach(lottoRank ->
                    System.out.println(
                            String.format("%d개 일치 (%d원)- %d개",
                                    lottoRank.getMatches(),
                                    lottoRank.getPrize(),
                                    statistics.getStatistics().get(lottoRank)))
                );

        System.out.println(String.format("총 수익률은 %.2f 입니다.", statistics.getEarningRate()));
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
