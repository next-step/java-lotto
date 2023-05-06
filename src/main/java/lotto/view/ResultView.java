package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResultChecker;
import lotto.domain.LottoTicket;

import java.util.Arrays;

public class ResultView {
    public void viewBuyingResult(LottoTicket[] lottoTickets) {
        System.out.println(lottoTickets.length + "개를 구매했습니다.");

        for (int i = 0; i < lottoTickets.length; i++) {
            System.out.println(lottoTickets[i].toString());
        }

        System.out.println("");
    }

    public void viewWinningResult(LottoResultChecker lottoResultChecker) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(LottoRank.NO_RANK))
                .forEach(rank -> System.out.println(rank.getDescription()
                        + " (" + rank.getPrizeMoney() + "원)- "
                        + lottoResultChecker.getRankCount(rank) + "개"));

    }

    public void viewRateOfInvestment(int investmentAmount, int investmentReturn) {
        double roi = (double) investmentReturn / investmentAmount;

        System.out.println("총 수익률은 " + roi + "입니다. (기준이 1이기 때문에 결과적으로는 손해라는 의미임)");
    }
}
