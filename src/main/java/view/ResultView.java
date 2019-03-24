package view;

import domain.LottoGame;
import domain.LottoResult;
import domain.LottoResultStatus;
import domain.Money;

public class ResultView {
    public static void printLottos(LottoGame result) {
        result.lottos().forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers().toString());
        });
    }

    public static void printLottoResult(LottoResult lottoResult, Money money) {
       System.out.println("당첨 통계");
       System.out.println("---------");
       System.out.println("3개 일치 (5,000원)- " +lottoResult.getLottoResult(LottoResultStatus.WINNING_NUM_3)+ "개");
       System.out.println("4개 일치 (50,000원)- " +lottoResult.getLottoResult(LottoResultStatus.WINNING_NUM_4)+ "개");
       System.out.println("5개 일치 (1,500,000원)- " +lottoResult.getLottoResult(LottoResultStatus.WINNING_NUM_5)+ "개");
       System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원)- " +lottoResult.getLottoResult(LottoResultStatus.WINNING_NUM_5_BONUS)+ "개");
       System.out.println("6개 일치 (2,000,000,000원)- " +lottoResult.getLottoResult(LottoResultStatus.WINNING_NUM_6)+ "개");
       System.out.println();
       System.out.println("총 수익률은 "+lottoResult.calculateBenefit(money)+ "입니다. ");
    }
}
