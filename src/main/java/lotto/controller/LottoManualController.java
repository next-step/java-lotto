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
        cashier.calculateAutoLottoQuantity(inputView.inputManualLottoQuantity());

        Lottos lottos = LottoFactory.createLottos(convertNumbersListToLottoList(inputView.inputManualLottoNumbers(cashier.getManualQuantity())), cashier.getAutoQuantity());
        outputView.printLottos(cashier.getManualQuantity(), cashier.getAutoQuantity(), lottos.getLottos());

        Lotto winningNumbers = convertNumbersToLotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResults winningResults = lottos.countWinningResults(winningLotto);
        outputView.printWinningResults(winningResults.getWinningResults());
        outputView.printEarningRate(winningResults.calculateEarningRate(cashier.getPrice()));
    }

    private List<Lotto> convertNumbersListToLottoList(List<String> stringNumbersList) {
        List<Lotto> lottos = new ArrayList<>();
        for(String stringNumbers : stringNumbersList) {
            lottos.add(convertNumbersToLotto(stringNumbers));
        }
        return lottos;
    }

    private Lotto convertNumbersToLotto(String stringNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        String[] splitNumbers = stringNumbers.split(", ");
        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            numbers.add(LottoNumber.of(number));
        }
        return new Lotto(numbers);
    }
}
