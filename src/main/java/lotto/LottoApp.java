package lotto;

import static lotto.LottoSheet.calculateSheetCount;
import static lotto.view.InputView.inputPayment;
import static lotto.view.ResultView.printLottoSheetCount;

public class LottoApp {
    public static void main(String[] args) {
        int lottoSheetCount = calculateSheetCount(inputPayment());

        printLottoSheetCount(lottoSheetCount);
    }
}

