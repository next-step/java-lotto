package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {

    public void start(List<Lotto> lottos) {
        LottoManualInputView inputView = new LottoManualInputView();
        LottoManualResultView resultView = new LottoManualResultView();

        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.getQuantity();

        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = quantity - manualQuantity;

        List<String> manualNumbers = inputView.inputManualLottoNumbers(manualQuantity);
        setManualLottos(manualQuantity, manualNumbers, lottos);
        setAutoLottos(autoQuantity, lottos);
        resultView.printLottos(manualQuantity, autoQuantity, lottos);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers(), inputView.inputBonusNumber());

        WinningResult winningResult = new WinningResult();
        winningResult.getWinningResult(lottos, winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());
        resultView.outputWinningStatistics(getEarningRate(getEarningPrice(), LottoPrice.getPrice()));
    }

    public void setManualLottos(int manualQuantity, List<String> manualNumbersString, List<Lotto> lottos) {
        for (int i = 0; i < manualQuantity; i++) {
            lottos.add(new Lotto(manualNumbersString.get(i)));
        }
    }

    public void setAutoLottos(int autoQuantity, List<Lotto> lottos) {
        for (int i = 0; i < autoQuantity; i++) {
            lottos.add(new Lotto());
        }
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
