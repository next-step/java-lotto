package lotto.domain;

import java.util.*;

public class LottoGame {
    private List<LottoTicket> tickets = new ArrayList<>();
    private WinnerNumbers winnerNumbers;

    public LottoGame(int numOfTickets, List<String []> manualLottoTickets) {
        LottoFactory lottoFactory = new LottoFactory(numOfTickets, manualLottoTickets);

        this.tickets.addAll(lottoFactory.tickets());
        this.winnerNumbers = new WinnerNumbers(lottoFactory.generateTicket());
    }

    public LottoGame(LottoTicket lottoTicket, List<Integer> winnerNumbers) {
        LottoFactory lottoFactory = new LottoFactory(lottoTicket);
        this.tickets = lottoFactory.tickets();
        this.winnerNumbers = new WinnerNumbers(winnerNumbers);
    }

    public List<LottoTicket> tickets() {
        return this.tickets;
    }

    public WinnerNumbers winnerNumbers() {
        return this.winnerNumbers;
    }

    public PrizeStatus processResult() {
        PrizeStatus prizeStatus = new PrizeStatus(this);
        return prizeStatus;
    }
}
