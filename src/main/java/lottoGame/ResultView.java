package lottoGame;

import java.util.List;

public class ResultView {
    public void printTicket(LottoGame lottoGame) {


        System.out.println("수동으로 " + lottoGame.getManualLottoCount() + "장, 자동으로 " + lottoGame.getAutoLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoGame.getLottoTicket()) {
            System.out.println(lotto);
        }
    }

    public void showResult(LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoGame.getFifthGrade() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGame.getFourthGrade() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoGame.getThirdGrade() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + lottoGame.getSecondGrade() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoGame.getFirstGrade() + "개");
        System.out.println("총 수익률은 "+ lottoGame.getRate()+"입니다.(기준이 1이기 때문에 결과적으로 "+ lottoGame.getResult()+"라는 의미임)");
    }
}
