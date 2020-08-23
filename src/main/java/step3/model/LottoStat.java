package step3.model;

import java.util.HashMap;
import java.util.List;

public class LottoStat {
    private HashMap<Rank, Integer> rank;

    public LottoStat() {
        rank = new HashMap<>();
        initializeRank();
    }

    private void initializeRank() {
        for (Rank r1 : Rank.values()) {
            rank.putIfAbsent(r1, 0);
        }
    }

    public void enterLottoTicketScore(List<LottoTicket> ticketList, String[] winningTicket, int bonusBallNumber) {
        for (LottoTicket value : ticketList) {
            rank.put(Rank.valueOf(value.matchedNumber(winningTicket)
                    , value.isBonusBallIncluded(bonusBallNumber)
                    ), rank.get(Rank.valueOf(value.matchedNumber(winningTicket)
                    , value.isBonusBallIncluded(bonusBallNumber)
                    )) + 1
            );
        }
    }

    public int getNumberOfGrade(Rank value) {
        return rank.get(value);
    }
}
