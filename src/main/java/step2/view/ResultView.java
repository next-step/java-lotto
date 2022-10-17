package step2.view;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.RankingAward;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printNumOfTickets(int numOfTickets) {
        System.out.println(numOfTickets + "개를 구매했습니다.");
    }

    public void printAllLottoNumbers(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
        System.out.println();
    }

    public void printWinningResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");

        for (Map.Entry<Integer, Integer> entry : lottoResult.getLottoRankings().entrySet()) {
            System.out.println(entry.getKey() + "개 일치 (" + RankingAward.getAward(entry.getKey()) + "원) - " + entry.getValue() + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getPrizePercentage() + "입니다.");
    }
}
