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

        LottoPrice lottoPrice = new LottoPrice(inputView.inputPrice());
        int quantity = lottoPrice.getQuantity();

        List<LottoModel> lottos = setLotto(quantity);
        resultView.printLotto(quantity, lottos);

        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumbers(), inputView.inputBonusNumber());

        WinningResult winningResult = new WinningResult();
        winningResult.getWinningResult(lottos, winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());
        resultView.outputWinningStatistic(getEarningRate(getEarningPrice(), LottoPrice.getPrice()));
    }

    public List<LottoModel> setLotto(int quantity) {
        List<LottoModel> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new LottoModel());
        }
        return lottos;
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
