package lotto.domain;

import java.util.List;
import java.util.Random;

public class LottoGame {
    private List<LottoTicket> tickets;
    private WinnerNumbers winnerNumbers;

    public LottoGame(int numOfTickets, Random random) {
        LottoFactory lottoFactory = new LottoFactory(numOfTickets, random);
        this.tickets = lottoFactory.tickets();
        this.winnerNumbers = new WinnerNumbers(lottoFactory.generateTicket(random));
    }

    public List<LottoTicket> tickets() {
        return this.tickets;
    }

    public WinnerNumbers winnerNumbers() {
        return this.winnerNumbers;
    }
}
