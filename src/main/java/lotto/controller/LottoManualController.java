package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {
    private LottoManualInputView inputView = new LottoManualInputView();
    private LottoManualOutputView outputView = new LottoManualOutputView();
    private LottoFactory lottoFactory = new LottoFactory();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());
        cashier.calculateAutoLottoQuantity(inputView.inputManualLottoQuantity());

        List<String> manualNumbers = inputView.inputManualLottoNumbers(cashier.getManualQuantity());

        List<Lotto> autoLottos = lottoFactory.createManualLottos(cashier.getManualQuantity(), manualNumbers);
        List<Lotto> manualLottos = lottoFactory.createAutoLottos(cashier.getAutoQuantity());
        List<Lotto> joinedLottos = new ArrayList<>();
        joinedLottos.addAll(autoLottos);
        joinedLottos.addAll(manualLottos);
        Lottos lottos = new Lottos(joinedLottos);
        outputView.printLottos(cashier.getManualQuantity(), cashier.getAutoQuantity(), lottos.getLottos());

        Lotto winningNumbers = convertWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResults winningResults = lottos.countWinningResults(winningLotto);
        outputView.printWinningResults(winningResults.getWinningResults());
        outputView.printEarningRate(winningResults.calculateEarningRate(cashier.getPrice()));
    }

    private Lotto convertWinningNumbers(String winningStringNumbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (String splitWinningNumber : splitWinningNumbers) {
            int number = Integer.parseInt(splitWinningNumber);
            winningNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(winningNumbers);
    }
}
