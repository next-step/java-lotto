package lotto;

import lotto.domain.LottoSheet;
import lotto.domain.WinningLottoNumbers;

import java.util.List;

import static lotto.domain.LottoSheet.calculateSheetCount;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningLottoNumbers;
import static lotto.view.ResultView.printLottoSheetCount;
import static lotto.view.ResultView.printLottoSheets;

public class LottoApp {
    public static void main(String[] args) {
        int lottoSheetCount = calculateSheetCount(inputPayment());
        printLottoSheetCount(lottoSheetCount);

        List<LottoSheet> lottoSheets = LottoSheet.create(lottoSheetCount);
        printLottoSheets(lottoSheets);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumbers());
    }
}

