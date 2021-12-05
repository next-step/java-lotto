package view;

public interface InputView {
    void showPurchaseAmountInputMessage();
    void showWinningNumberInputMessage();
    int extractPurchaseAmount();
    String extractWinningNumber();
}
