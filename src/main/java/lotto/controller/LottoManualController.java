package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {

    public void start() {
        LottoManualInputView inputView = new LottoManualInputView();
        LottoManualResultView resultView = new LottoManualResultView();
        ManualLottos manualLottos = new ManualLottos();

        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.getQuantity();

        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = quantity - manualQuantity;

        List<String> manualNumbers = inputView.inputManualLottoNumbers(manualQuantity);
        List<Lotto> lottos = manualLottos.setLotto(manualQuantity, autoQuantity, manualNumbers);

        resultView.printLottos(manualQuantity, autoQuantity, lottos);

        List<Integer> winningNumbers = convertWinningNumbersToInt(inputView.inputWinningNumbers());
        int bonusNumber = convertBonusNumberToInt(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningResult winningResult = new WinningResult();
        winningResult.getWinningResult(lottos, winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());
        resultView.outputWinningStatistics(getEarningRate(getEarningPrice(), LottoPrice.getPrice()));
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

    public int getEarningPrice() {
        return (WinningPrice.FIFTH_PRICE.getPrice() * WinningResult.getNumberOfFifthPlace()
                + WinningPrice.FOURTH_PRICE.getPrice() * WinningResult.getNumberOfFourthPlace()
                + WinningPrice.THIRD_PRICE.getPrice() * WinningResult.getNumberOfThirdPlace()
                + WinningPrice.SECOND_PRICE.getPrice() * WinningResult.getNumberOfSecondPlace()
                + WinningPrice.FIRST_PRICE.getPrice() * WinningResult.getNumberOfFirstPlace());
    }
}
