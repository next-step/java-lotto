package step2.view;

import step2.service.Lotto;
import step2.service.LottoRank;
import step2.vo.CountOfWinners;
import step2.vo.LottoResults;

import java.util.Map;

public class ResultView {

    private final LottoResults lottoResults;

    public ResultView(LottoResults lottoResults) {
        this.lottoResults = lottoResults;
    }

    public void showNumOfTickets(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다");
    }

    public void showLottoGameResults() {
        for (Lotto lotto : lottoResults.getLottoResults()) {
            System.out.println(lotto.lottoNumbers());
        }
        System.out.println();
    }

    public void showLottoWinners(CountOfWinners countOfWinners) {
        Map<LottoRank, Integer> winnerResults = countOfWinners.getWinnerResults();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + winnerResults.get(LottoRank.FOURTH) + "개");
        System.out.println("4개 일치 (50000원)- " + winnerResults.get(LottoRank.THIRD) + "개");
        System.out.println("5개 일치 (1500000원)- " + winnerResults.get(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)- " + winnerResults.get(LottoRank.FIRST) + "개");
    }

    public void showRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
