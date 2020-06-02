package study.lotto.view;

import study.lotto.model.Lottos;
import study.lotto.model.LottoRank;
import study.lotto.model.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ResultView {
    private static final int EARNING_RATE_SCALE = 2;

    public static void printPurchaseMessage(int numOfLotto, Lottos lottos) {
        System.out.println(numOfLotto + "개를 구매했습니다.");

        printLottoList(lottos);
        printEmptyLine();
    }

    public static void printStatisticsMessage(Statistics statistics, BigDecimal earningRate) {
        printEmptyLine();
        printStatistics(statistics);
        printEarningRate(earningRate);
    }

    private static void printLottoList(Lottos lottos) {
        lottos.getLottoList()
                .forEach(System.out::println);
    }

    private static void printStatistics(Statistics statistics) {
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
    }

    private static void printEarningRate(BigDecimal earningRate) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(EARNING_RATE_SCALE);
        format.setRoundingMode(RoundingMode.HALF_EVEN);

        System.out.println(String.format("총 수익률은 %s 입니다.", format.format(earningRate)));
    }

    private static void printEmptyLine() {
        System.out.println();
    }
}
