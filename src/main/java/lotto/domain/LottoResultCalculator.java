package lotto.domain;

import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoResult;
import lotto.domain.model.Rank;

import java.util.List;

public class LottoResultCalculator {

    public LottoResult calculate(final List<LottoTicket> lottoTickets, final LottoTicket winningLottoTicket) {
        LottoResult result = new LottoResult();
        for (LottoTicket ticket : lottoTickets) {
            int matchCount = countMatches(ticket, winningLottoTicket);

            result.addResult(Rank.of(matchCount));
        }
        return result;
    }

    private int countMatches(final LottoTicket lottoTicket, final LottoTicket winningLottoTicket) {
        int matches = 0;
        for (int number : lottoTicket.getNumbers()) {
            if (winningLottoTicket.contains(number)) {
                matches++;
            }
        }
        return matches;
    }
}
