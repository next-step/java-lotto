package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersResults;
import lotto.domain.WinningLottoNumbers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoNumbers.calculateNumbersCount;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoApp {

    public static void main(String[] args) {
        int payment = inputPayment();
        int lottoNumbersCount = calculateNumbersCount(payment);
        int manualLottoNumbersCount = inputManualNumbersCount();

        List<LottoNumbers> lottoNumbersList = setLottoNumberList(lottoNumbersCount, manualLottoNumbersCount);
        printLottoNumbersCount(lottoNumbersCount, manualLottoNumbersCount);

        printLottoNumbersList(lottoNumbersList);
        LottoNumbersResults lottoNumbersResults = new WinningLottoNumbers(
                inputWinningLottoNumbers(), inputLottoBonusNumber()).getResult(lottoNumbersList);

        printLottoResults(lottoNumbersResults);
        printLottoProfits(payment, lottoNumbersResults);
    }

    public static List<LottoNumbers> setLottoNumberList(int sheetCount, int manualSheetCount) {
        List<LottoNumbers> manualNumbersList = inputLottoNumbers(manualSheetCount).stream()
                .map(LottoNumbers::new)
                .collect(Collectors.toList());

        List<LottoNumbers> autoNumbersList = LottoNumbers.generate(sheetCount - manualSheetCount);

        return Stream.of(manualNumbersList, autoNumbersList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

