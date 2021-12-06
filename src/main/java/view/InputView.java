package view;

public interface InputView {
    void showPurchaseAmountInputMessage();
    void showWinningNumberInputMessage();
    void showBonusBallInputMessage();
    int purchaseAmount();
    String winningNumber();
    int bonusBall();
}
