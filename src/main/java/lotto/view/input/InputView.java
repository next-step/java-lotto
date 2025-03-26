package lotto.view.input;

import lotto.domain.UserPaid;
import lotto.domain.product.LotteryTicket;

public interface InputView {

    String read();

    UserPaid purchase();

    void closeScanner();

    LotteryTicket lastWeekNumber();
}
