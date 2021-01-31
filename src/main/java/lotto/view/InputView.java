package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public interface InputView {

    PurchaseAmount getPurchaseAmount();

    LottoTicket getWinningTicket();

    LottoNumber getBonusNumber();
}
