package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.Money;

public class LottoResultView {

    public void printPurchaseLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoRank, Integer> statistics = lottoStatistics.getStatistics();

        Arrays.stream(LottoRank
            .values())
            .filter(rank -> rank.getPrize().compareTo(Money.ZERO) > 0)
            .forEach(rank -> printRankStat(statistics, rank));
    }

    private void printRankStat(Map<LottoRank, Integer> statistics, LottoRank rank) {
        System.out.println(
            rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원)- " + statistics.getOrDefault(rank, 0) + "개");
    }

    public void printRoi(BigDecimal roi) {
        System.out.println("총 수익률은 " + roi + "입니다.");
    }

}
