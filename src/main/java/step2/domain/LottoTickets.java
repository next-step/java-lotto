package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(int lottoCount) {
        createLottoTickets(lottoCount);
    }

    private void createLottoTickets(int lottoCount) {
        this.lottoTickets = new ArrayList<>();

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

    public void prepareWinner(List<Integer> winnerNums, Bonus bonus, Ranks countOfRanks) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = lottoTicket.countMatchNumber(winnerNums);
            countOfRanks.countWinning(lottoTicket, matchCount, bonus);
        }
    }
}
