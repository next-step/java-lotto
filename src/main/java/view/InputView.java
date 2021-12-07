package view;

public interface InputView {
    void showPurchaseAmountInputMessage();
    void showManualPurchaseAmountInputMessage();
    void showManualLottoInputMessage();
    void showWinningNumberInputMessage();
    void showBonusBallInputMessage();
    int purchaseAmount();
    String winningNumber();
    int bonusBall();
}
