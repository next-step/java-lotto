package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoController {

    public void start() {
        LottoAutoInputView inputView = new LottoAutoInputView();
        LottoAutoResultView resultView = new LottoAutoResultView();
        AutoLottos autoLottos = new AutoLottos();

        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.getQuantity();

        List<Lotto> lottos = autoLottos.setLotto(quantity);
        resultView.printLotto(quantity, lottos);

        List<Integer> winningNumbers = convertWinningNumbersToInt(inputView.inputWinningNumbers());
        int bonusNumber = convertBonusNumberToInt(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResult winningResult = new WinningResult(lottos, winningLotto);

        resultView.outputWinningStatistic(getEarningRate(getEarningPrice(), LottoPrice.getPrice()));
    }

    public List<Integer> convertWinningNumbersToInt(String winningStringNumbers) {
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

    private float getEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
    }

    private int getEarningPrice() {
        return (WinningPrice.FIFTH_PRICE.getPrice() * WinningResult.getNumberOfFifthPlace()
                + WinningPrice.FOURTH_PRICE.getPrice() * WinningResult.getNumberOfFourthPlace()
                + WinningPrice.THIRD_PRICE.getPrice() * WinningResult.getNumberOfThirdPlace()
                + WinningPrice.SECOND_PRICE.getPrice() * WinningResult.getNumberOfSecondPlace()
                + WinningPrice.FIRST_PRICE.getPrice() * WinningResult.getNumberOfFirstPlace());
    }
}
