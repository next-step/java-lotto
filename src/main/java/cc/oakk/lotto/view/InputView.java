package cc.oakk.lotto.view;

import java.util.List;

public interface InputView {
    int readMoney();
    List<Integer> readWinningNumbers();

    void printMoneyInputHeader();
    void printWinningNumberInputHeader();
}
