package lotto.common.handler;

public class UiExceptionHandler {
    private static final int LOTTO_PRICE = 1000;

    public boolean inputAmountHandle(String amount) {
        int convertedAmount;
        try {
            convertedAmount = Integer.parseInt(amount);
            if (convertedAmount < LOTTO_PRICE) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("로또 구입 금액은 1000원 이상이 되어야 합니다.");
            System.out.println("");
            return true;
        }
        return false;
    }

    public static int calculateAutoCount(int inputAmount, int manualCount) {
        int manualLottoPurchaseAmount  = manualCount * LOTTO_PRICE;
        int autoCount = 0;
        if (inputAmount < manualLottoPurchaseAmount) {
            return autoCount;
        }
        autoCount = (inputAmount / LOTTO_PRICE) - manualCount;
        return autoCount;
    }
}
