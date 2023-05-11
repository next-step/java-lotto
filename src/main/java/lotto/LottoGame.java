package lotto;

import java.util.List;

public class LottoGame {
    LottoTickets lottoTickets;
    List<Integer> winningNumbers;

    public LottoGame(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public int getCountOfMatchingNumber(int number) {
        lottoTickets.countMatchingTickets(winningNumbers);
        return lottoTickets.getCountOfMatchingNumber(number);
    }
}
