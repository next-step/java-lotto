package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.RankingAward;
import lotto.util.LottoUtil;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printNumOfTickets(int numOfTickets) {
        System.out.println(numOfTickets + "개를 구매했습니다.");
    }

    public void printAllLottoNumbers(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(LottoUtil.convertToIntegers(lottoTicket.getNumbers()));
        }
        System.out.println();
    }

    public void printWinningResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");

        for (Map.Entry<Integer, Integer> entry : lottoResult.getLottoRankings().entrySet()) {
            printBonusBallResult(entry.getKey(), entry.getValue());
        }
        System.out.println("총 수익률은 " + lottoResult.getPrizePercentage() + "입니다.");
    }

    private void printBonusBallResult(int ranking, int award) {
        if (ranking == 7) {
            System.out.println((ranking - 2) + "개 일치, 보너스 볼 일치 (" + RankingAward.getAward(ranking) + "원) - " + award + "개");
            return;
        }
        System.out.println(ranking + "개 일치 (" + RankingAward.getAward(ranking) + "원) - " + award + "개");
    }
}
