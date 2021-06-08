package lotto.controller;

import lotto.model.*;
import lotto.view.LottoManualInputView;
import lotto.view.LottoManualOutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoManualController {
    private LottoManualInputView inputView = new LottoManualInputView();
    private LottoManualOutputView outputView = new LottoManualOutputView();
    private AutoLotto autoLotto = new AutoLotto();
    private ManualLotto manualLotto = new ManualLotto();
    private WinningResult winningResult;

    public void start() {
        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.calculateLottoQuantity();
        int manualQuantity = inputView.inputManualLottoQuantity();
        int autoQuantity = quantity - manualQuantity;

        List<String> manualNumbers = inputView.inputManualLottoNumbers(manualQuantity);

        Lottos lottos = createLottos(autoQuantity, manualQuantity, manualNumbers);
        outputView.printLottos(manualQuantity, autoQuantity, lottos.getLottos());

        Lotto winningNumbers = new Lotto(convertWinningNumbers(inputView.inputWinningNumbers()));
        LottoNumber bonusNumber = convertBonusNumber(inputView.inputBonusNumber());
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

    private List<LottoNumber> convertWinningNumbers(String winningStringNumbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        String[] splitWinningNumbers = winningStringNumbers.split(", ");
        for (int i = 0; i < splitWinningNumbers.length; i++) {
            int number = Integer.parseInt(splitWinningNumbers[i]);
            winningNumbers.add(new LottoNumber(number));
        }
        return winningNumbers;
    }

    private LottoNumber convertBonusNumber(String bonusStringNumber) {
        int bonusNumber = Integer.parseInt(bonusStringNumber);
        return new LottoNumber(bonusNumber);
    }
}
