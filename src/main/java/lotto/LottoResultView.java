package lotto;

import java.util.List;
import java.util.Map;

public class LottoResultView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toStringLottoNumbers());
        }
    }

    public static void printLottoStatistics(Map<LottoRank, Integer> lottosStatistics) {
        for (Map.Entry result : lottosStatistics.entrySet()) {
            LottoRank lottoRank = (LottoRank) result.getKey();
            Integer resultCount = (Integer) result.getValue();

            System.out.println(lottoRank.getMatchCount() + "개 일치" + (lottoRank == LottoRank.SECOND ? ", 보너스 볼 일치" : "") + " (" + lottoRank.getWinningAmount() + "원)- " + resultCount + "개");
        }
    }

    public static void printLottoYield(double lottoYield) {
        System.out.println("총 수익률은 " + lottoYield + "입니다.");
    }

}
