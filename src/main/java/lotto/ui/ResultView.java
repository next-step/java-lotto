package lotto.ui;

import lotto.domain.*;

import java.util.Map;

public class ResultView {
    private ResultView(){}

    public static void printPurchaseCount(PurchaseQuantity all, PurchaseQuantity manual){
        System.out.printf("%n수동으로  %d장, 자동으로  %d개를 구매했습니다.%n",manual.find(),(all.find()-manual.find()));
    }

    public static void printLottoList(Lottos lottos){
        for(Lotto lotto : lottos.find()){
            System.out.println(lotto.find());
        }
    }

    public static void printStatistics(Map<LottoRank,Integer> resultMap){
        System.out.printf("%n당첨 통계%n");
        System.out.println("---------");
        for(LottoRank lottoRank : resultMap.keySet()){
            System.out.printf("%d개 일치",lottoRank.count());
            checkBonus(lottoRank);
            System.out.printf("(%d원)- %d개%n",lottoRank.prize(),resultMap.get(lottoRank));
        }
    }

    private static void checkBonus(LottoRank lottoRank) {
        if(lottoRank == LottoRank.SECOND){
            System.out.print("보너스 볼 일치");
        }
    }

    public static void printRateOfReturn(Money seed, Money revenue){
        System.out.printf("총 수익률은 %.2f입니다.",seed.rateOfReturn(revenue.find()));
        checkLoss(seed, revenue);
    }

    private static void checkLoss(Money seed, Money revenue) {
        if(seed.rateOfReturn(revenue.find())<1){
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
