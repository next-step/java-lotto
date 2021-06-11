package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningResult {
    private static final int HUNDREDTHS_PLACE = 100;
    private static final int RANK_INITIAL_COUNT = 0;
    private List<Rank> foundRanks = new ArrayList<>();
    private HashMap<Rank, Integer> results = new HashMap<>();
    private int foundRankCount;
    private double yield;

    public WinningResult(LottoTickets lottoTickets, WinningLotto winningLotto, int purchase) {
        resetResult();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            Rank lottoRank = Rank.findLottoRank(winningLotto.getWinningCount(lottoTicket),
                    winningLotto.isWinningBonusNumber(lottoTicket));
            foundRanks.add(lottoRank);
        }
        countFoundRank();
        calculateYield(purchase);
    }

    private void resetResult() {
        for (Rank rank : Rank.values()) {
            results.put(rank, RANK_INITIAL_COUNT);
        }
    }

    private void countFoundRank() {
        for (Rank rank : foundRanks) {
            foundRankCount = (int) foundRanks.stream()
                    .filter(foundRank -> foundRank.equals(rank))
                    .count();
            results.put(rank, foundRankCount);
        }
    }

    public void calculateYield(int purchase) {
        yield = Math.floor((sumWinningPrize() / (double) purchase) * HUNDREDTHS_PLACE)
                / HUNDREDTHS_PLACE;
    }

    private double sumWinningPrize() {
        return foundRanks.stream()
                .mapToInt(Rank::getWinningPrize)
                .sum();
    }

    public HashMap<Rank, Integer> getResults() {
        return results;
    }

    public double getYield() {
        return yield;
    }
}
