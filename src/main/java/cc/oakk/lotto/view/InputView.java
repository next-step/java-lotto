package cc.oakk.lotto.view;

import java.util.List;

public interface InputView {
    int readMoney();
    int readManualLottoCount();
    List<Integer> readNumbers();
    int readBonusNumber();

    void printMoneyInputHeader();
    void printManualLottoCountInputHeader();
    void printManualLottoNumbersInputHeader();
    void printWinningNumberInputHeader();

    void printBonusNumberInputHeader();

    void printError(Throwable throwable);
}
