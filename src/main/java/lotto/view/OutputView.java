package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.LottoNumbers;
import lotto.model.LottoRank;

public class OutputView {

    public void printLotto(List<LottoNumbers> lottoNumbersList) {
        System.out.println(lottoNumbersList.size() + "개를 구매했습니다.");
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void printStatistics(Map<LottoRank, Integer> lottoRankMap, double returnRate) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.equals(LottoRank.BLANK)) {
                continue;
            }
            Integer t = lottoRankMap.get(lottoRank);
            if (t == null) {
                t = 0;
            }
            System.out.println(lottoRank.rank() + "개 일치 (" + lottoRank.money() + ") - " + t + "개");
        }
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }
}
