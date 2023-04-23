package step2.view;

import step2.LottoRank;
import step2.vo.LottoResult;
import step2.vo.LottoResults;
import step2.vo.WinnerInfo;

import java.util.Map;

public class ResultView {

    private final LottoResults lottoResults;

    public ResultView(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public void showLottoGameResults() {
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            System.out.println(lottoResult.toString());
        }
        System.out.println();
    }

    public void showLottoWinners(WinnerInfo winnerInfo) {
        Map<LottoRank, Integer> winnerResults = winnerInfo.getWinnerResults();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winnerResults.get(LottoRank.MATCH_THREE) + "개");
        System.out.println("4개 일치 (50000원)- " + winnerResults.get(LottoRank.MATCH_FOUR) + "개");
        System.out.println("5개 일치 (1500000원)- " + winnerResults.get(LottoRank.MATCH_FIVE) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winnerResults.get(LottoRank.MATCH_SIX) + "개");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
