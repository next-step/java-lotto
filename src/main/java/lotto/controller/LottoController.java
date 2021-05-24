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

        PurchaseInformation purchaseInfo = new PurchaseInformation(inputView.inputPrice(), inputView.inputManualPurchaseCount());
        LottoNumbersGenerator autoGenerator = new AutoLottoNumbersGenerator(purchaseInfo.autoCount(), new RandomNumbersGenerator());
        LottoNumbersGenerator manualGenerator = new ManualLottoNumbersGenerator(purchaseInfo.manualCount(), inputView.inputManualPurchaseNumbers(purchaseInfo.manualCount()));

        List<LottoNumbers> totalLottoNumbersList = new ArrayList<>();

        totalLottoNumbersList.addAll(autoGenerator.generate());
        totalLottoNumbersList.addAll(manualGenerator.generate());

        printView.printLottoNumbers(totalLottoNumbersList, purchaseInfo);

        LottoTickets lottoTickets = LottoTickets.of(totalLottoNumbersList, WinningNumbers.of(inputView.inputWinningNumbers(), inputView.inputBonusNumber()));

        LottoResult lottoResult = lottoTickets.matchResult();
        printView.printResult(lottoResult, purchaseInfo.getPrice());
    }
}
