package lotto.model;

import java.util.List;

public class LottoGame {
    private LottoTicket winningTicket;
    private List<LottoTicket> userLottoTickets;

    public LottoGame(LottoTicket winningTicket, List<LottoTicket> userLottoTickets) {
        this.winningTicket = winningTicket;
        this.userLottoTickets = userLottoTickets;
    }

    public ScoreMap getScores() {
        ScoreMap scoreMap = new ScoreMap();
        for (LottoTicket userLottoTicket : userLottoTickets) {
            scoreMap.updateByMatchCount(winningTicket.howManyMatched(userLottoTicket));
        }
        return scoreMap;
    }
}
