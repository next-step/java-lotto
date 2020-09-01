package cc.oakk.lotto.view;

import java.util.List;

public interface InputView {
    int readMoney();
    List<Integer> readWinningNumbers();
    int readBonusNumber();

    void printMoneyInputHeader();
    void printWinningNumberInputHeader();

    void printBonusNumberInputHeader();
}
