package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    List<LottoTicket> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public void add(LottoTicket lottoTicket) {
        this.lottoTickets.add(lottoTicket);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void getWinner(List<Integer> winnerNums, Ranks countOfRanks) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = matchNumber(lottoTicket.getLottoNums(), winnerNums);
            countOfRanks.countWinning(matchCount);
        }
    }

    public int matchNumber(List<Integer> candidateNums, List<Integer> winnerNums) {
        Long matchNumer = candidateNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(matchNumer);
    }
}
