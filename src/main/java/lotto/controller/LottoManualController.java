package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {
<<<<<<< HEAD
    LottoManualInputView inputView = new LottoManualInputView();
    LottoManualOutputView outputView = new LottoManualOutputView();
    AutoLotto autoLotto = new AutoLotto();
    ManualLotto manualLotto = new ManualLotto();
    WinningResult winningResult;

    public void start() {
        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.calculateLottoQuantity();
        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = quantity - manualQuantity;

        List<String> manualNumbers = inputView.inputManualLottoNumbers(manualQuantity);

        Lottos lottos = createLottos(autoQuantity, manualQuantity, manualNumbers);
        outputView.printLottos(manualQuantity, autoQuantity, lottos.getLottos());

        Lotto winningNumbers = new Lotto(convertWinningNumbersToInt(inputView.inputWinningNumbers()));
        int bonusNumber = convertBonusNumberToInt(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottos.countWinningResults(winningLotto.getWinningNumbers(), winningLotto.getBonusNumber(), winningResult);
        outputView.outputWinningResults(winningResult.getNumberOfWins());
        outputView.outputEarningRate(lottos.calculateEarningRate(winningResult.calculateEarningPrice(), lottoPrice.getPrice()));
    }

    private Lottos createLottos(int autoQuantity, int manualQuantity, List<String> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(autoLotto.createLottos(autoQuantity));
        lottos.addAll(manualLotto.createLottos(manualQuantity, manualNumbers));
        return new Lottos(lottos);
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
    private final LottoManualInputView inputView = new LottoManualInputView();
    private final LottoManualOutputView outputView = new LottoManualOutputView();

    public void start() {
        Cashier cashier = new Cashier(inputView.inputPrice());
        Counter counter = new Counter(cashier.getLottoQuantity());
        counter.calculateAutoQuantity(inputView.inputManualLottoQuantity());

        Lottos lottos = LottoFactory.createLottos(convertNumbersListToLottoList(inputView.inputManualLottoNumbers(counter.getManualQuantity())), counter.getAutoQuantity());
        outputView.printLottos(counter.getManualQuantity(), counter.getAutoQuantity(), lottos.getLottos());

        WinningLotto winningLotto = createWinningLotto();

        WinningResults winningResults = lottos.countWinningResults(winningLotto);
        outputView.printWinningResults(winningResults.getWinningResults());
        outputView.printEarningRate(winningResults.calculateEarningRate(cashier.getPrice()));
    }

    private List<Lotto> convertNumbersListToLottoList(List<String> stringNumbersList) {
        List<Lotto> lottos = new ArrayList<>();
        for(String stringNumbers : stringNumbersList) {
            lottos.add(convertNumbersToLotto(stringNumbers));
        }
        return lottos;
    }

    private Lotto convertNumbersToLotto(String stringNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        String[] splitNumbers = stringNumbers.split(", ");
        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            numbers.add(LottoNumber.of(number));
        }
        return new Lotto(numbers);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = convertNumbersToLotto(inputView.inputWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(inputView.inputBonusNumber());
        return new WinningLotto(winningNumbers, bonusNumber);
>>>>>>> origin/step2
    }
}
