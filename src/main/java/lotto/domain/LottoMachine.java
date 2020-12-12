package lotto.domain;

public interface LottoMachine {

    LottoTickets automatic(long amount);

    LottoTicket manual(String numbers);

    WinningLotto winning(String winningNumbers, String bonusNumber);
}
