package lottoauto.view;

import lottoauto.service.LottoGame;

public class ResultView {
    public static void printLottoGameResult(LottoGame lottoGame){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoGame.getMatchThreeCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGame.getMatchFourCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGame.getMatchFiveCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGame.getMatchSixCount() + "개");
    }

    public static void printLottoGameProfitRate(LottoGame lottoGame) {
        System.out.print("총 수익률은 " + lottoGame.getProfitRate() + "입니다.");
        if(lottoGame.getLottoCount() < 1){
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
