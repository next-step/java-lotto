package lottoauto.view;

import lottoauto.domain.LottoReport;
import lottoauto.service.LottoGame;

public class ResultView {
    public static void printLottoGameResult(LottoReport lottoReport){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoReport.getMatchThreeCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoReport.getMatchFourCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoReport.getMatchFiveCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoReport.getMatchSixCount() + "개");
    }

    public static void printLottoGameProfitRate(LottoReport lottoReport) {
        System.out.print("총 수익률은 " + lottoReport.getProfitRate() + "입니다.");
        if(lottoReport.getProfitRate() < 1){
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
