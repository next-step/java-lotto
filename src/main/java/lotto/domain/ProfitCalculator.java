package lotto.domain;

import java.util.List;

public class ProfitCalculator {

    public int calculateProfit(List<LottoTicket> lottoTickets) {
        return lottoTickets.stream().mapToInt(this::calculate).sum();
    }

    public int calculate(LottoTicket lottoTicket) {
        long matchingScore = lottoTicket.getMatchingScore();
        if (matchingScore == 0) {
            return 0;
        }
        return ProfitRule.getProfitByMatchingScore(matchingScore).getProfit();
    }
}
