package step2.view;

import step2.LottoRank;
import step2.vo.LottoResult;
import step2.vo.LottoResults;

public class ResultView {

    private final int numOfLottoTicket;

    private final LottoResults lottoResults;

    public ResultView(int numOfLottoTicket, LottoResults lottoResults) {
        this.numOfLottoTicket = numOfLottoTicket;
        this.lottoResults = lottoResults;
    }

    public void showLottoGameResults() {
        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            System.out.println(lottoResult.toString());
        }
        System.out.println();
    }

    public void showLottoWinners() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + LottoRank.MATCH_THREE.numOfWinner() + "개");
        System.out.println("4개 일치 (50000원)- " + LottoRank.MATCH_FOUR.numOfWinner() + "개");
        System.out.println("5개 일치 (1500000원)- " + LottoRank.MATCH_FIVE.numOfWinner() + "개");
        System.out.println("6개 일치 (2000000000원)- " + LottoRank.MATCH_SIX.numOfWinner() + "개");

        double rateOfReturn = LottoRank.calculateRateOfReturn(numOfLottoTicket);
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
