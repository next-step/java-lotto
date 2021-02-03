package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseResult;

public interface InputView {

    PurchaseAmount getPurchaseAmount();

    PurchaseResult getManualPurchasedTickets(final PurchaseAmount amount);

    LottoTicket getWinningTicket();

    LottoNumber getBonusNumber();
}
