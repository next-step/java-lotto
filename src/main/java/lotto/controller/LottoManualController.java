package lotto.controller;

import lotto.model.LottoPrice;
import lotto.model.WinningPrice;
import lotto.model.WinningResult;
import lotto.model.LottoModel;
import lotto.view.LottoManualView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {

    public void start(List<LottoModel> lottos) {
        LottoManualView view = new LottoManualView();

        int price = view.inputPrice();

        LottoPrice lottoPrice = new LottoPrice();
        int quantity = lottoPrice.getQuantity(price);

        int manualQuantity = view.inputManualLottoQuantity();
        int autoQuantity = quantity - manualQuantity;

        List<String> manualNumbers = view.inputManualLottoNumbers(manualQuantity);
        setManualLottos(manualQuantity, manualNumbers, lottos);
        setAutoLottos(autoQuantity, lottos);
        view.printLottos(manualQuantity, autoQuantity, lottos);

        List<Integer> winningNumbers = convertWinningNumbersToInt(view.inputWinningNumbers());
        int bonusNumber = convertBonusNumberToInt(view.inputBonusNumber());

        checkWinningNumbers(winningNumbers);
        checkBonusNumber(bonusNumber);

        WinningResult winningResult = new WinningResult();
        winningResult.getWinningResult(lottos, winningNumbers, bonusNumber);
        view.outputWinningStatistics(getEarningRate(getEarningPrice(), price));
    }

    public void setManualLottos(int manualQuantity, List<String> manualNumbersString, List<LottoModel> lottos) {
        for (int i = 0; i < manualQuantity; i++) {
            lottos.add(new LottoModel(manualNumbersString.get(i)));
        }
    }

    public void setAutoLottos(int autoQuantity, List<LottoModel> lottos) {
        for (int i = 0; i < autoQuantity; i++) {
            lottos.add(new LottoModel());
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

    private int convertBonusNumberToInt(String bonusStringNumber) {
        int bonusNumber = Integer.parseInt(bonusStringNumber);
        return bonusNumber;
    }

    private void checkWinningNumbers(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            checkNumber(number);
        }
    }

    private void checkBonusNumber(int bonusNumber) {
        checkNumber(bonusNumber);
    }

    private void checkNumber(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지의 숫자입니다.");
        }
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
