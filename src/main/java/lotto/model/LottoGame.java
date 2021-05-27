package lotto.model;

import java.util.List;

public class LottoGame {
    private LottoTicket winningTicket;
    private List<LottoTicket> userLottoTickets;

    public LottoGame(LottoTicket winningTicket, List<LottoTicket> userLottoTickets) {
        this.winningTicket = winningTicket;
        this.userLottoTickets = userLottoTickets;
    }

    public int howManyMatched(LottoTicket userNumbers) {
        return winningTicket.howManyMatched(userNumbers);
    }

    public ScoreMap getLottoResult() {
        ScoreMap scoreMap = new ScoreMap();
        for (LottoTicket userLottoTicket : userLottoTickets) {
            scoreMap.updateWithNumMatched(winningTicket.howManyMatched(userLottoTicket));
        }
        return scoreMap;
    }
}
