package view;

import java.util.List;

import domain.FirstPlaceLotto;
import domain.Lotto;
import domain.Lottos;
import domain.type.LottoRankResult;

public class ResultView {
    public static void printLottoResult(Lottos lottos) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottos.getLottoRankCount(LottoRankResult.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + lottos.getLottoRankCount(LottoRankResult.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + lottos.getLottoRankCount(LottoRankResult.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)- " + lottos.getLottoRankCount(LottoRankResult.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottos.getLottoRankCount(LottoRankResult.FIRST) + "개");
        System.out.println("총 수익률은 " + lottos.getProfitRate() + "입니다.");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> {
            printLotto(lotto);
        });
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers().toString());
    }

    public static void printLotto(FirstPlaceLotto lotto) {
        System.out.println(lotto.getLottoNumbers().toString());
    }
}