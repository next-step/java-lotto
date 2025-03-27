package lotto.view.input;

import lotto.domain.PaymentReceipt;
import lotto.domain.product.LotteryTicket;

public interface InputView {

    String read();

    PaymentReceipt purchase();

    void closeScanner();

    LotteryTicket lastWeekNumber();
}
