package study.lotto.view;

import study.lotto.model.LottoList;
import study.lotto.model.LottoRank;
import study.lotto.model.Statistics;

import java.util.Arrays;

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

        System.out.println("총 수익률은 " + String.format("%.2f", statistics.getEarningRate()) + "입니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
