package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final LastWinningNumbers lastWeeksWinningNumbers;

    public LottoGame(LottoTickets lottoTickets, LastWinningNumbers lastWeeksWinningNumbers) {
        this.lottoTickets = lottoTickets;
        this.lastWeeksWinningNumbers = lastWeeksWinningNumbers;
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
        List<Number> ticketNumbers = lottoTickets.getLottoTicket(lottoTicketIndex).getTicket();

        countOfMatch = lastWeeksWinningNumbers.calculateCountOfMatch(ticketNumbers);

        lottoResult.saveLottoResult(countOfMatch, lastWeeksWinningNumbers.isMatchBonus(countOfMatch, ticketNumbers));
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
