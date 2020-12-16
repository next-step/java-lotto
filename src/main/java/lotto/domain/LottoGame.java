package lotto.domain;

public class LottoGame {

    private LottoTickets lottoTickets;

    public LottoGame(int money, TicketMachine ticketMachine) {
        this.lottoTickets = new LottoTickets(money, ticketMachine);
    }

    public MatchResult match(String winningNumbers, String bonusNumber) {
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        return lottoTickets.match(winningTicket);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
