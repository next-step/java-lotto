package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
    private final LottoAutoInputView inputView = new LottoAutoInputView();
    private final LottoAutoOutputView outputView = new LottoAutoOutputView();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());

        Lottos lottos = new Lottos(LottoFactory.createAutoLottos(cashier.getLottoQuantity()));
        outputView.printLotto(cashier.getLottoQuantity(), lottos.getLottos());

        WinningLotto winningLotto = createWinningLotto();

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

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = convertWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }
}
