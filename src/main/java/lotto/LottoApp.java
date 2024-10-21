package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersResults;
import lotto.domain.WinningLottoNumbers;

import java.util.List;

import static lotto.domain.LottoNumbers.calculateSheetCount;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApp {
    public static void main(String[] args) {
        int payment = inputPayment();
        int lottoSheetCount = calculateSheetCount(payment);
        printLottoSheetCount(lottoSheetCount);

        List<LottoNumbers> lottoNumbersList = LottoNumbers.generate(lottoSheetCount);
        printLottoSheets(lottoNumbersList);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
                inputWinningLottoNumbers(), inputLottoBonusNumber());

        LottoNumbersResults lottoNumbersResults = winningLottoNumbers.getResult(lottoNumbersList);
        printLottoResults(lottoNumbersResults);

        printLottoProfits(payment, lottoNumbersResults);
    }
}

