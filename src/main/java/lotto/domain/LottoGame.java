package lotto.domain;

import lotto.domain.machine.ComplexTicketMachine;

public class LottoGame {

    private LottoTickets lottoTickets;

    public LottoGame(LottoUserRequest lottoUserRequest, ComplexTicketMachine complexTicketMachine) {
        this.lottoTickets = new LottoTickets(complexTicketMachine.issue(lottoUserRequest));
    }

    public MatchResult match(String winningNumbers, String bonusNumber) {
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        return lottoTickets.match(winningTicket);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
