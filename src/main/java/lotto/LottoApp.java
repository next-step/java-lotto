package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersResults;

import java.util.List;

import static lotto.domain.LottoNumbers.calculateSheetCount;
import static lotto.view.InputView.inputPayment;
import static lotto.view.InputView.inputWinningLottoNumbers;
import static lotto.view.ResultView.*;

public class LottoApp {
    public static void main(String[] args) {
        int payment = inputPayment();
        int lottoSheetCount = calculateSheetCount(payment);
        printLottoSheetCount(lottoSheetCount);

        List<LottoNumbers> lottoNumbersList = LottoNumbers.generate(lottoSheetCount);
        printLottoSheets(lottoNumbersList);

        LottoNumbers winningLottoNumbers = new LottoNumbers(inputWinningLottoNumbers());
        LottoNumbersResults lottoSheetResults = winningLottoNumbers.getResult(lottoNumbersList);
        printLottoResults(lottoSheetResults);

        printLottoProfits(payment, lottoSheetResults);
    }
}

