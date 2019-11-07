package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(int lottoCount) {
        this.lottoTickets = new ArrayList<>();
        createLottoTickets(lottoCount);
    }

    private void createLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void setWinner(List<Integer> winnerNums, Bonus bonus, Ranks countOfRanks) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.matchNumber(winnerNums);
            countOfRanks.countWinning(matchCount);
            countOfRanks.countBouns(lottoTicket, matchCount, bonus);
        }
    }
}
