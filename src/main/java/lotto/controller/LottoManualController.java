package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {
    private LottoManualInputView inputView = new LottoManualInputView();
    private LottoManualOutputView outputView = new LottoManualOutputView();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());
        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = cashier.calculateAutoLottoQuantity(manualQuantity);

        List<String> manualNumbers = inputView.inputManualLottoNumbers(manualQuantity);

        Lottos lottos = new Lottos(autoQuantity, manualQuantity, manualNumbers);
        outputView.printLottos(manualQuantity, autoQuantity, lottos.getLottos());

        Lotto winningNumbers = convertWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResults winningResults = lottos.countWinningResults(winningLotto);
        lottos.countWinningResults(winningLotto);
        outputView.outputWinningResults(winningResults.getWinningResults());
        outputView.outputEarningRate(winningResults.calculateEarningRate(cashier.getPrice()));
    }

    private Lotto convertWinningNumbers(String winningStringNumbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int number = Integer.parseInt(splitWinningNumbers[i]);
            winningNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(winningNumbers);
    }
}
