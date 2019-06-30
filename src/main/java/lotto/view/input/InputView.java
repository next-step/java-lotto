package lotto.view.input;

import java.util.List;

public interface InputView {
    Long getPurchaseAmount();
    List<Long> getWinningTicket();
    Long getBonusNumber();
}