package lottoauto.view;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoReport;
import lottoauto.domain.LottoStatus;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoGameResult(LottoReport lottoReport){
        Map<LottoStatus, Integer> winningMap = lottoReport.getWinningMap();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winningMap.get(LottoStatus.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + winningMap.get(LottoStatus.FOURTH)  + "개");
        System.out.println("5개 일치 (1500000원)- " + winningMap.get(LottoStatus.THIRD)  + "개");
        System.out.println("5개 일치 보너스 볼 일치(30000000원) - " + winningMap.get(LottoStatus.SECOND)  + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningMap.get(LottoStatus.FIRST)  + "개");
    }

    public static void printLottoGameProfitRate(LottoReport lottoReport) {
        System.out.print("총 수익률은 " + lottoReport.getProfitRate() + "입니다.");
        if(lottoReport.getProfitRate() < 1){
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static void printLottos(List<Lotto> all) {
        for (Lotto lotto : all) {
            System.out.println(lotto.getNumbers());
        }
    }
}
