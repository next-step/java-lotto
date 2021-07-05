package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
    private LottoAutoInputView inputView = new LottoAutoInputView();
    private LottoAutoOutputView outputView = new LottoAutoOutputView();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());
        int quantity = cashier.calculateLottoQuantity();

        Lottos lottos = new Lottos(quantity);
        outputView.printLotto(quantity, lottos.getLottos());

        Lotto winningNumbers = convertWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = inputView.inputBonusNumber();
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
