package view;

import java.util.List;

public interface InputView {
    void showPurchaseAmountInputMessage();
    void showManualPurchaseAmountInputMessage();
    int manualPurchaseAmount();
    void showManualLottoInputMessage();
    List<Integer> manualLottoNumbers();
    void showWinningNumberInputMessage();
    void showBonusBallInputMessage();
    int purchaseAmount();
    String winningNumber();
    int bonusBall();
}
