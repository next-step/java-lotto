package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
    LottoAutoInputView inputView = new LottoAutoInputView();
    LottoAutoOutputView outputView = new LottoAutoOutputView();
    AutoLotto autoLotto = new AutoLotto();
    WinningResult winningResult ;

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
    }
}
