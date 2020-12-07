package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final List<Integer> lastWeeksWinningNumbers;
    private final LottoResult lottoResult;
    private final int bonusNumber;

    public LottoGame(LottoTickets lottoTickets, List<Integer> lastWeeksWinningNumbers, int bonusNumber) {
        lottoResult = new LottoResult(lottoTickets.size());
        this.lottoTickets = lottoTickets;
        this.lastWeeksWinningNumbers = lastWeeksWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getLottoResult() {
        for (int lottoTicketIndex = 0; lottoTicketIndex < lottoTickets.size(); lottoTicketIndex++) {
            saveCountOfMatch(lottoTicketIndex);
        }

        return lottoResult;
    }

    private void saveCountOfMatch(int lottoTicketIndex) {
        int countOfMatch = 0;
        List<Integer> ticketNumbers = lottoTickets.getLottoTicket(lottoTicketIndex).getTicket();

        for (Integer lastWeeksWinningNumber : lastWeeksWinningNumbers) {
            countOfMatch = getCountOfMatch(countOfMatch, ticketNumbers, lastWeeksWinningNumber);
        }

        lottoResult.saveLottoResult(countOfMatch, isMatchBonus(countOfMatch, ticketNumbers));
    }

    private int getCountOfMatch(int countOfMatch, List<Integer> ticketNumbers, Integer lastWeeksWinningNumber) {
        if (ticketNumbers.contains(lastWeeksWinningNumber)) {
            countOfMatch++;
        }

        return countOfMatch;
    }

    private boolean isMatchBonus(int countOfMatch, List<Integer> ticketNumbers) {
        if (countOfMatch == 5) {
            return ticketNumbers.contains(bonusNumber);
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottoTickets, lottoGame.lottoTickets) &&
                Objects.equals(lastWeeksWinningNumbers, lottoGame.lastWeeksWinningNumbers) &&
                Objects.equals(lottoResult, lottoGame.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets, lastWeeksWinningNumbers, lottoResult);
    }
}
