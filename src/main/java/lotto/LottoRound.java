package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRound {
    private static final int WINNING_COUNT_THRESHOLD = 3;
    private final List<LottoTicket> lottoTickets;

    public LottoRound(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoWinners getWinners(LottoTicket winningTicket) {
        List<LottoWinner> result = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets) {
            int count = ticket.getMatchingCount(winningTicket);
            addWinner(result, ticket, count);
        }
        return new LottoWinners(result);
    }

    private void addWinner(List<LottoWinner> result, LottoTicket ticket, int matchingCount) {
        if (matchingCount >= WINNING_COUNT_THRESHOLD) {
            result.add(new LottoWinner(matchingCount, ticket));
        }
    }
}
