package lotto;

import static lotto.ui.LottoDisplay.display;

public class LottoApplication {
    public static void main(String[] args) {
        BuyingLottoUserInterface
            .entryPoint()
                .inputPurchaseAmount()
                .inputManualLottoCount()
                .inputManualLottos()
            .displayLottoStoreInformation()
        .orUserInputErrorDisplay(LottoApplication::displayUserErrorLog);
    }

    private static void displayUserErrorLog(Exception e) {
        display("[사용자 등록 오류 발생]");
        display(e.getMessage());
    }
}
