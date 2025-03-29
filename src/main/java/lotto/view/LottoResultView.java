package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Money;

public class LottoResultView {

    public void printPurchaseLotto(List<LottoResult> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoResult lotto : lottos) {
            System.out.println(lotto.display());
        }
        System.out.println();
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        List<LottoRank> printableLottoRanks = Arrays.stream(LottoRank.values())
                .filter(rank -> rank.getPrize().compareTo(Money.ZERO) > 0)
                .collect(Collectors.toList());

        for (LottoRank rank : printableLottoRanks) {
            System.out.println(LottoRankFormatter.format(rank) + " - " + lottoStatistics.getCountByRank(rank) + "개");
        }
    }

    public void printRoi(BigDecimal roi) {
        System.out.println("총 수익률은 " + roi + "입니다.");
    }

}
