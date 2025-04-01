package lotto.view.input;

import lotto.domain.PaymentReceipt;
import lotto.domain.Quantity;
import lotto.domain.product.LotteryTickets;
import lotto.domain.product.LottoNumber;
import lotto.domain.product.WinningTicket;

public interface InputView {

    String read();

    PaymentReceipt purchase();

    void closeScanner();

    WinningTicket getWinningTicket();

    LottoNumber getBonusNumber();

    Quantity getManualLotteryQuantity();

    LotteryTickets getManualLotteryTickets(Quantity manualQuantity);
}
