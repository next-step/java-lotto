package lotto.view.input;

import lotto.domain.PaymentReceipt;
import lotto.domain.Quantity;
import lotto.domain.product.lotto.LotteryTickets;
import lotto.domain.product.lotto.LottoNumber;
import lotto.domain.product.lotto.WinningTicket;

public interface InputView {

    String read();

    PaymentReceipt purchase();

    void closeScanner();

    WinningTicket getWinningTicket();

    LottoNumber getBonusNumber();

    Quantity getManualLotteryQuantity();

    LotteryTickets getManualLotteryTickets(Quantity manualQuantity);
}
