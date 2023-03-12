package view;

import domain.LottoRank;
import domain.Lottos;
import domain.type.LottoRankAmount;

public class ResultView {
    public static void printLottoResult(Lottos lottos) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottos.getLottoRankCount(LottoRankAmount.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + lottos.getLottoRankCount(LottoRankAmount.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + lottos.getLottoRankCount(LottoRankAmount.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.getLottoRankCount(LottoRankAmount.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottos.getLottoRankCount(LottoRankAmount.FIRST) + "개");
        System.out.println("총 수익률은 " + lottos.getProfitRate() + "입니다.");
    }
}