package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets() {
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

    public void getWinner(List<Integer> winnerNums, Map<Integer, Integer> countOfRanks) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = matchNumber(lottoTicket.getLottoNums(), winnerNums);
            countWinning(matchCount, countOfRanks);
        }
    }

    public int matchNumber(List<Integer> candidateNums, List<Integer> winnerNums) {
        Long matchNumer = candidateNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(matchNumer);
    }

    private void countWinning(int matchCount, Map<Integer, Integer> countOfRanks) {
        countOfRanks.put(matchCount, countOfRanks.getOrDefault(matchCount, 0) + 1);
    }
}
