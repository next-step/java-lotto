package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {
    private static final int HUNDREDTHS_PLACE = 100;
    private List<Rank> results = new ArrayList<>();

    public WinningResult(LottoTickets lottoTickets, WinningNumber winningNumber) {
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            Rank lottoRank = Rank.findLottoRank(winningNumber.getWinningCount(lottoTicket),
                    winningNumber.isWinningBonusNumber(lottoTicket));
            results.add(lottoRank);
        }
    }

    public int countFifthPlace() {
        return (int) results.stream()
                .filter(rank -> rank.equals(Rank.FIFTH_PLACE))
                .count();
    }

    public int countFourthPlace() {
        return (int) results.stream()
                .filter(rank -> rank.equals(Rank.FOURTH_PLACE))
                .count();
    }

    public int countThirdPlace() {
        return (int) results.stream()
                .filter(rank -> rank.equals(Rank.THIRD_PLACE))
                .count();
    }

    public int countSecondPlace() {
        return (int) results.stream()
                .filter(rank -> rank.equals(Rank.SECOND_PLACE))
                .count();
    }

    public int countFirstPlace() {
        return (int) results.stream()
                .filter(rank -> rank.equals(Rank.FIRST_PLACE))
                .count();
    }

    public double sumWinningPrize() {
        return results.stream()
                .mapToInt(Rank::getWinningPrize)
                .sum();
    }

    public double calculateYield(int purchase) {
        return Math.floor((sumWinningPrize() / (double) purchase) * HUNDREDTHS_PLACE)
                / HUNDREDTHS_PLACE;
    }
}
