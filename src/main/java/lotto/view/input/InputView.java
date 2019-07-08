package lotto.view.input;

import lotto.common.Csv;
import lotto.common.PositiveNumber;

import java.util.List;

public interface InputView {
    PositiveNumber getPurchaseAmount();
    List<Csv> getManualTicketNumbers();
    Csv getWinningTicket();
    PositiveNumber getBonusNumber();
}