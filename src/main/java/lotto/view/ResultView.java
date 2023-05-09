package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.enums.LottoPrize;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void autoLottoPrint(List<Lotto> lottoList) {
        System.out.println();

        lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoStatistics(WinnerLotto winnerLotto, Lottos lottos) {
        LottoStatistics lottoStatistics = new LottoStatistics(winnerLotto, lottos);
        String statisticsString = formatLottoStatistics(lottoStatistics);
        System.out.println(statisticsString);
    }

    public static String formatLottoStatistics(LottoStatistics lottoStatistics) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n------\n");

        Map<LottoPrize, Integer> matchCountsMap = lottoStatistics.getMatchCountsMap();
        printMatchCount(sb, matchCountsMap);

        double yield = lottoStatistics.calculateYield();
        sb.append(String.format("총 수익률은 %.2f%s 입니다. ", yield, (yield > 1 ? "" : " (기준이 1이기 때문에 결과적으로 손해라는 의미임)")));
        return sb.toString();
    }

    private static void printMatchCount(final StringBuilder sb, final Map<LottoPrize, Integer> matchCountsMap) {
        List<LottoPrize> prizes = makeReversePrize();

        for (LottoPrize prize : prizes) {
            int matchCount = prize.getMatchCount();
            int prizeMoney = prize.getPrizeMoney();
            int matchCountValue = matchCountsMap.getOrDefault(prize, 0);

            sb.append(String.format("%d 개 일치", matchCount));
            if (prize == LottoPrize.SECOND) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(String.format(" (%s) 원 - %d 개\n", prizeMoneyFormat(prizeMoney), matchCountValue));
        }
    }

    private static List<LottoPrize> makeReversePrize() {
        List<LottoPrize> prizes = Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() >= 3)
                .collect(Collectors.toList());
        Collections.reverse(prizes);
        return prizes;
    }

    private static String prizeMoneyFormat(int prizeMoney) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(prizeMoney);
    }

}
