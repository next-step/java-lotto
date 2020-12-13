package lotto.domain;

import java.util.List;

public interface LottoMachine {

    LottoTickets generate(long amount, List<String> manualNumbers);

    WinningLotto winning(String winningNumbers, String bonusNumber);
}
