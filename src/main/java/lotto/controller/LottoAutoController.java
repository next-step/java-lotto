package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
    private final LottoAutoInputView inputView = new LottoAutoInputView();
    private final LottoAutoOutputView outputView = new LottoAutoOutputView();
    private final LottoFactory lottoFactory = new LottoFactory();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());

        List<Lotto> autoLottos = lottoFactory.createAutoLottos(cashier.getLottoQuantity());
        Lottos lottos = new Lottos(autoLottos);
        outputView.printLotto(cashier.getLottoQuantity(), lottos.getLottos());

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
