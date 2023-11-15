package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoBundle(List<Lotto> result) {
        for (Lotto lotto : result) {
            System.out.println(lotto.find().toString());
        }
        System.out.println();
    }

    public static void printMatchStats(Map<LottoRank, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank lottoRank : resultMap.keySet()) {
            System.out.printf("%d개 일치", lottoRank.count());
            if (lottoRank.name().equals("SECOND")) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf("(%d원)- ", lottoRank.prize());
            System.out.printf("%d개%n", resultMap.get(lottoRank));
        }

    }

    public static void printMatchResult(int purchaseAmount, long prizeAmount) {
        float result = (float) prizeAmount / purchaseAmount;
        System.out.printf("총 수익률은 %.2f입니다.", result);
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

    }

}
