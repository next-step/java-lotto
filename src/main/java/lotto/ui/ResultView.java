package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Money;
import lotto.domain.PurchaseQuantity;

import java.util.List;
import java.util.Map;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoCount(PurchaseQuantity all, PurchaseQuantity manual) {
        System.out.println("수동으로 "+manual.find()+"장, 자동으로 "+(all.diff(manual).find())+"개를 구매했습니다.");
    }

    public static void printLottoBundle(List<Lotto> result) {
        for (Lotto lotto : result) {
            System.out.println(lotto.find());
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

    public static void printMatchResult(Money revenue, Money seed) {
        float result = revenue.rateOfReturn(seed);
        System.out.printf("총 수익률은 %.2f입니다.", result);
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

    }

}
