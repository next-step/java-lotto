package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final LastWinningNumbers lastWeeksWinningNumbers;
    private final BonusNumber bonusNumber;

    public LottoGame(LottoTickets lottoTickets, LastWinningNumbers lastWeeksWinningNumbers, BonusNumber bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.lastWeeksWinningNumbers = lastWeeksWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult getLottoResult() {
        LottoResult lottoResult = new LottoResult(lottoTickets.size());
        for (int lottoTicketIndex = 0; lottoTicketIndex < lottoTickets.size(); lottoTicketIndex++) {
            saveCountOfMatch(lottoTicketIndex, lottoResult);
        }

        return lottoResult;
    }

    private void saveCountOfMatch(int lottoTicketIndex, LottoResult lottoResult) {
        int countOfMatch = 0;
        List<Integer> ticketNumbers = lottoTickets.getLottoTicket(lottoTicketIndex).getTicket();

        for (Integer lastWeeksWinningNumber : lastWeeksWinningNumbers.getWinningNumbers()) {
            countOfMatch = sumCountOfMatch(countOfMatch, ticketNumbers, lastWeeksWinningNumber);
        }

        lottoResult.saveLottoResult(countOfMatch, isMatchBonus(countOfMatch, ticketNumbers));
    }

    private int sumCountOfMatch(int countOfMatch, List<Integer> ticketNumbers, Integer lastWeeksWinningNumber) {
        if (ticketNumbers.contains(lastWeeksWinningNumber)) {
            countOfMatch++;
        }

        return countOfMatch;
    }

    private boolean isMatchBonus(int countOfMatch, List<Integer> ticketNumbers) {
        if (countOfMatch == 5) {
            return ticketNumbers.contains(bonusNumber.getNumber());
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottoTickets, lottoGame.lottoTickets) &&
                Objects.equals(lastWeeksWinningNumbers, lottoGame.lastWeeksWinningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets, lastWeeksWinningNumbers);
    }
}
