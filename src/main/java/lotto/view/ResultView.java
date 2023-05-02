package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.enums.LottoPrize;

import java.util.List;

public class ResultView {

    public static void autoLottoPrint(List<Lotto> lottoList) {
        System.out.println();

        lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoStatistics(List<Lotto> lottos, Lotto winnerLotto) {
        LottoStatistics lottoStatistics = new LottoStatistics(winnerLotto, lottos);
        String statisticsString = formatLottoStatistics(lottoStatistics);
        System.out.println(statisticsString);
    }

    public static String formatLottoStatistics(LottoStatistics lottoStatistics) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n------\n");

        int[] matchCounts = lottoStatistics.getMatchCounts();
        printMatchCount(sb, matchCounts);

        double yield = lottoStatistics.calculateYield();
        sb.append(String.format("총 수익률은 %.2f%s 입니다. ", yield, (yield > 1 ? "" : " (기준이 1이기 때문에 결과적으로 손해라는 의미임)")));
        return sb.toString();
    }

    private static void printMatchCount(final StringBuilder sb, final int[] matchCounts) {
        for (int i = 0; i < matchCounts.length; i++) {
            int matches = i + 3;
            LottoPrize prize = LottoPrize.valueOf(matches);
            sb.append(String.format("%d 개 일치 (%s) 원 - %d 개\n", matches, prize.getPrizeMoneyFormat(), matchCounts[i]));
        }
    }
}
