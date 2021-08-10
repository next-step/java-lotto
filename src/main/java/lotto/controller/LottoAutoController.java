package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
<<<<<<< HEAD
    LottoAutoInputView inputView = new LottoAutoInputView();
    LottoAutoOutputView outputView = new LottoAutoOutputView();
    AutoLotto autoLotto = new AutoLotto();
    WinningResult winningResult;

    public void start() {
        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.calculateLottoQuantity();

        Lottos lottos = new Lottos(autoLotto.createLottos(quantity));
        outputView.printLotto(quantity, lottos.getLottos());

        Lotto winningNumbers = new Lotto(convertWinningNumbersToInt(inputView.inputWinningNumbers()));
        int bonusNumber = convertBonusNumberToInt(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottos.countWinningResults(winningLotto.getWinningNumbers(), winningLotto.getBonusNumber(), winningResult);
        outputView.outputWinningResults(winningResult.getNumberOfWins());
        outputView.outputEarningRate(lottos.calculateEarningRate(winningResult.calculateEarningPrice(), lottoPrice.getPrice()));
    }

    private List<Integer> convertWinningNumbersToInt(String winningStringNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int number = Integer.parseInt(splitWinningNumbers[i]);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private int convertBonusNumberToInt(String bonusStringNumber) {
        int bonusNumber = Integer.parseInt(bonusStringNumber);
        return bonusNumber;
=======
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
>>>>>>> origin/step2
    }
}
