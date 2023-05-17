package lotto.view;

import lotto.domain.Money;
import lotto.domain.enums.LottoRank;
import lotto.domain.LottoResultChecker;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public void viewBuyingResult(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        lottoTickets.stream().forEach(n -> System.out.println(n.toString()));

        System.out.println("");
    }

    public void viewWinningResult(LottoResultChecker lottoResultChecker) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(LottoRank.NO_RANK))
                .forEach(rank -> {
                    System.out.println(buildResultMessage(lottoResultChecker, rank));
                });

    }

    private String buildResultMessage(LottoResultChecker lottoResultChecker, LottoRank rank) {
        String result = rank.getMatchedCount() + "개 일치";

        if (rank.equals(rank.isBonusMatched())) {
            result += ", 보너스 볼 일치";

        }
        result += "(" + rank.getPrizeMoney().getLong() + "원)- "
                + lottoResultChecker.getRankCount(rank) + "개";

        return result;
    }

    public void viewRateOfInvestment(Money investmentAmount, Money investmentReturn) {
        double roi = investmentReturn.divide(investmentAmount);

        System.out.print("총 수익률은 " + roi + "입니다. ");
        if (roi < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로는 손해라는 의미임)");
        }
        System.out.println();
    }
}
