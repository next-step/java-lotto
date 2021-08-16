package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {
    private final LottoManualInputView inputView = new LottoManualInputView();
    private final LottoManualOutputView outputView = new LottoManualOutputView();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());
        Counter counter = new Counter(cashier.getLottoQuantity());
        counter.calculateAutoQuantity(inputView.inputManualLottoQuantity());

        Lottos lottos = LottoFactory.createLottos(convertNumbersListToLottoList(inputView.inputManualLottoNumbers(counter.getManualQuantity())), counter.getAutoQuantity());
        outputView.printLottos(counter.getManualQuantity(), counter.getAutoQuantity(), lottos.getLottos());

        WinningLotto winningLotto = createWinningLotto();

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

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = convertNumbersToLotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
