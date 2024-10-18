package lotto.io;

import java.util.List;

public interface InputHandler {

    long getPurchaseAmountFromUser();

    List<Integer> getLottoNumbersFromUser();

    int getOneNumberFromUser();

    List<List<Integer>> getManualPurchaseLottoNumbers(int manualLottoPurchaseCount);
}
