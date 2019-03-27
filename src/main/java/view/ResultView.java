package view;

import domain.*;

import java.util.Arrays;

public class ResultView {
    public static void printLottos(LottoGame result) {
        result.lottos().forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers().toString());
        });
    }

    public static void printLottoResult(LottoResult lottoResult, Money money) {
       System.out.println("당첨 통계");
       System.out.println("---------");

       Arrays.stream(LottoResultStatus.values()).filter(status-> !status.equals(LottoResultStatus.NONE)).forEach(resultStatus -> {
           System.out.println(resultStatus.findDescription() + " - " + lottoResult.getLottoResult(resultStatus)+" 개");
       });

       System.out.println();
       System.out.println("총 수익률은 "+lottoResult.calculateBenefit(money)+ "입니다. ");
    }
}
