package lotto.view.input;

import lotto.domain.PaymentReceipt;
import lotto.domain.product.LottoNumber;
import lotto.domain.product.WinningTicket;

public interface InputView {

    String read();

    PaymentReceipt purchase();

    void closeScanner();

    WinningTicket getWinningTicket();

    LottoNumber getBonusNumber();
}
