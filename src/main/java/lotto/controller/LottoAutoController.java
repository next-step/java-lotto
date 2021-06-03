package lotto.controller;

import lotto.model.*;
import lotto.view.LottoAutoInputView;
import lotto.view.LottoAutoResultView;

import java.util.List;

public class LottoAutoController {

    public void start() {
        LottoAutoInputView inputView = new LottoAutoInputView();
        LottoAutoResultView resultView = new LottoAutoResultView();
        AutoLotto autoLotto = new AutoLotto();

        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.getQuantity();

        List<Lotto> lottos = autoLotto.setLotto(quantity);
        resultView.printLotto(quantity, lottos);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers(), inputView.inputBonusNumber());

        WinningResult winningResult = new WinningResult(lottos, winningLotto);

        resultView.outputWinningStatistic(getEarningRate(getEarningPrice(), LottoPrice.getPrice()));
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
