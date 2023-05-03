package lotto.view;

import lotto.domain.LottoTickets;
import lotto.dto.WinningResult;
import lotto.enums.Rank;

import java.util.Map;

public class ResultView {

    public void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(o -> System.out.println(o.getLottoNumbers()));
    }

    public void printWiningResult(WinningResult winningResult) {
        System.out.println(getWinningResultForm(winningResult));
    }

    public String getWinningResultForm(WinningResult winningResult) {
        Map<Rank, Integer> rankCount = winningResult.getRankCount();
        double totalReturn = winningResult.getTotalReturn();
        return "당첨 통계" +
                "\n ---------" +
                "\n 3개 일치 (5000원)- " + rankCount.getOrDefault(Rank.FOURTH_PLACE, 0) + "개 " +
                "\n 4개 일치 (50000원)- " + rankCount.getOrDefault(Rank.THIRD_PLACE, 0) + "개" +
                "\n 5개 일치 (1500000원)- " + rankCount.getOrDefault(Rank.SECOND_PLACE, 0) + "개" +
                "\n 5개 일치, 보너스 볼 일치 (30000000)- " + rankCount.getOrDefault(Rank.BONUS_PLACE, 0) + "개" +
                "\n 6개 일치 (2000000000원)- " + rankCount.getOrDefault(Rank.FIRST_PLACE, 0) + "개" +
                "\n 총 수익률은 " + totalReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
