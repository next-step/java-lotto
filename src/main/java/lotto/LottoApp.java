package lotto;

import lotto.domain.LottoSheet;
import lotto.domain.LottoSheetResults;
import lotto.domain.WinningLottoNumbers;

import java.util.List;

import static lotto.domain.LottoSheet.calculateSheetCount;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningLottoNumbers;
import static lotto.view.ResultView.*;

public class LottoApp {
    public static void main(String[] args) {
        int payment = inputPayment();
        int lottoSheetCount = calculateSheetCount(payment);
        printLottoSheetCount(lottoSheetCount);

        List<LottoSheet> lottoSheets = LottoSheet.create(lottoSheetCount);
        printLottoSheets(lottoSheets);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumbers());
        LottoSheetResults lottoSheetResults = LottoSheetResults.create(
                winningLottoNumbers, lottoSheets);
        printLottoResults(lottoSheetResults);

        printLottoProfits(payment, lottoSheetResults);
    }
}

