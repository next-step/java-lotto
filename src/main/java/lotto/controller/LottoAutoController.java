package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {
    private LottoAutoInputView inputView = new LottoAutoInputView();
    private LottoAutoOutputView outputView = new LottoAutoOutputView();
    private AutoLotto autoLotto = new AutoLotto();
    private WinningResult winningResult;

    public void start() {
        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.calculateLottoQuantity();

        Lottos lottos = new Lottos(autoLotto.createLottos(quantity));
        outputView.printLotto(quantity, lottos.getLottos());

        Lotto winningNumbers = convertWinningNumbers(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottos.countWinningResults(winningLotto.getWinningNumbers(), winningLotto.getBonusNumber(), winningResult);
        outputView.outputWinningResults(winningResult.getNumberOfWins());
        outputView.outputEarningRate(lottos.calculateEarningRate(winningResult.calculateEarningPrice(), lottoPrice.getPrice()));
    }

    private Lotto convertWinningNumbers(String winningStringNumbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (String splitWinningNumber : splitWinningNumbers) {
            int number = Integer.parseInt(splitWinningNumber);
            winningNumbers.add(new LottoNumber(number));
        }
        return new Lotto(winningNumbers);
    }
}
