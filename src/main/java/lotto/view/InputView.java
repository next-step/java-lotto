package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

public interface InputView {

    int getPurchaseAmount();

    LottoTicket getWinningTicket();

    LottoNumber getBonusNumber();
}
