package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;

public class LottoResultView {

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printStatistics(int investMoney, LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoRank, Integer> statistics = lottoStatistics.getStatistics();

        printRankStat(statistics, LottoRank.MATCH_3);
        printRankStat(statistics, LottoRank.MATCH_4);
        printRankStat(statistics, LottoRank.MATCH_5);
        printRankStat(statistics, LottoRank.MATCH_6);
        printRoi(investMoney, statistics);
    }

    private void printRankStat(Map<LottoRank, Integer> statistics, LottoRank rank) {
        System.out.println(
            rank.getMatchCount() + "개 일치 (" + rank.getPrizeMoney() + "원)- " + statistics.getOrDefault(rank, 0) + "개");
    }

    private void printRoi(int investMoney, Map<LottoRank, Integer> statistics) {
        int totalPrize = statistics.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
            .sum();

        BigDecimal roi = BigDecimal.valueOf(totalPrize)
            .divide(BigDecimal.valueOf(investMoney), 2, RoundingMode.HALF_UP);

        System.out.println("총 수익률은 " + roi + "입니다.");
    }

}
