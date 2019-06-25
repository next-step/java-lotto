package lotto.view.input;

import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

import java.util.List;

public interface InputView {
    PurchaseAmount getPurchaseAmount();
    LottoTicket getWinningTicket();
}