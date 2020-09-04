package cc.oakk.lotto.view;

import java.util.List;

public interface InputView {
    int readMoney();
    int readManualLottoCount();
    List<Integer> readNumbers();
    int readBonusNumber();

    void printManualLottoNumbersInputHeader();
    void printWinningNumberInputHeader();

    void printError(Throwable throwable);
}
