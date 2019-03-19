package view;

import domain.LottoGame;
import domain.LottoResult;
import domain.LottoResultStatus;

public class ResultView {
    public static void printLottos(LottoGame result) {
        result.lottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers().toString());
        });
    }

    public static void printLottoResult(LottoResult lottoResult) {
       System.out.println("당첨 통계");
       System.out.println("---------");
       System.out.println("3개 일치 (5000원)- " +lottoResult.getLottoResults().get(LottoResultStatus.WINNING_NUM_3)+ "개");
       System.out.println("4개 일치 (50000)- " +lottoResult.getLottoResults().get(LottoResultStatus.WINNING_NUM_4)+ "개");
       System.out.println("5개 일치 (1500000원)- " +lottoResult.getLottoResults().get(LottoResultStatus.WINNING_NUM_5)+ "개");
       System.out.println("6개 일치 (2000000원)- " +lottoResult.getLottoResults().get(LottoResultStatus.WINNING_NUM_6)+ "개");

       System.out.println("총 수익률은 "+lottoResult.getBenefitRate()+ "입니다. ");
    }
}
