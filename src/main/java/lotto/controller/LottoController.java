package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PrintView printView = new PrintView();

        PurchaseInformation purchaseInfo = inputView.inputPriceAndManualCount();
        AutoLottoNumbersGenerator autoGenerator = new AutoLottoNumbersGenerator(new RandomLottoNumbersGenerator());
        ManualLottoNumbersGenerator manualGenerator = new ManualLottoNumbersGenerator();

        List<LottoNumbers> totalLottoNumbersList = new ArrayList<>();

        totalLottoNumbersList.addAll(autoGenerator.generate(purchaseInfo.autoCount()));
        totalLottoNumbersList.addAll(manualGenerator.generate(purchaseInfo.manualCount(), inputView.inputManualPurchaseNumbers(purchaseInfo.manualCount())));

        printView.printLottoNumbers(totalLottoNumbersList, purchaseInfo);

        LottoTickets lottoTickets = LottoTickets.of(totalLottoNumbersList, WinningNumbers.of(inputView.inputWinningNumbers(), inputView.inputBonusNumber()));

        printView.printResult(purchaseInfo.resultMessage(lottoTickets.matchResult()));
    }
}
