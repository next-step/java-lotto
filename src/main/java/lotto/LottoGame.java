package lotto;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final List<Integer> lastWeeksWinningNumbers;
    private final LottoResult lottoResult;

    public LottoGame(LottoTickets lottoTickets, List<Integer> lastWeeksWinningNumbers) {
        lottoResult = new LottoResult(lottoTickets.size());
        this.lottoTickets = lottoTickets;
        this.lastWeeksWinningNumbers = lastWeeksWinningNumbers;
    }

    public LottoResult getLottoResult() {
        for (int lottoTicketIndex = 0; lottoTicketIndex < lottoTickets.size(); lottoTicketIndex++) {
            findCountOfMatch(lottoTicketIndex);
        }

        return lottoResult;
    }

    private void findCountOfMatch(int lottoTicketIndex) {
        int countOfMatch = 0;
        List<Integer> ticketNumbers = lottoTickets.getLottoTicket(lottoTicketIndex).getTicket();
        for (Integer lastWeeksWinningNumber : lastWeeksWinningNumbers) {
            if (ticketNumbers.contains(lastWeeksWinningNumber)) {
                countOfMatch++;
            }
        }

        lottoResult.saveLottoResult(countOfMatch);
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
