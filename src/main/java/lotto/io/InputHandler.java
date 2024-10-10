package lotto.io;

import lotto.domain.ticket.WinningLotto;

public interface InputHandler {

    long getPurchaseAmountFromUser();

    WinningLotto getWinningNumbersFromUser();
}
