package lotto;

import java.util.List;

public class OutputView {

    static void printPurchaseLottoNumber(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.lottoNumber());
        }
    }

    static void printWinnerSummary(List<Integer> summaryCounts){
        for(int i = 0; i<summaryCounts.size(); i++){
            int printNumber = i + 3;
            System.out.println(printNumber + "개 일치 "+LottoEnum.findByPrice(printNumber + "개 일치 ").price()+" - " + summaryCounts.get(i) + "개");
        }
    }

    static void printRateOfReturn(double rateOfReturn){
        System.out.println("총 수익률은 "+rateOfReturn+" 입니다.");
    }

}
