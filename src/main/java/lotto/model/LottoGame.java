package lotto.model;

import java.util.List;

public class LottoGame {
    private LottoTicket winningTicket;
    private List<LottoTicket> userLottoTickets;
    private int expense;

    public LottoGame(LottoTicket winningTicket, List<LottoTicket> userLottoTickets, int expense) {
        this.winningTicket = winningTicket;
        this.userLottoTickets = userLottoTickets;
        this.expense = expense;
    }

    public int howManyMatched(LottoTicket userNumbers) {
        return winningTicket.howManyMatched(userNumbers);
    }

    public ScoreMap makeScoreMap() {
        ScoreMap scoreMap = new ScoreMap();
        for (LottoTicket userLottoTicket : userLottoTickets) {
            scoreMap.updateWithNumMatched(winningTicket.howManyMatched(userLottoTicket));
        }
        return scoreMap;
    }

    public LottoResult getLottoResult(){
        ScoreMap scoreMap = makeScoreMap();
        int totalReward = scoreMap.calculateReward();
        return new LottoResult(scoreMap, totalReward, expense);
    }
}
