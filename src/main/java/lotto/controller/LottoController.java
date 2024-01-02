package lotto.controller;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        int totalPriceToBuyLotto = InputView.totalPrice();
        int numberOfLotto = totalPriceToBuyLotto / 1000;
        OutputView.numberOfLotto(numberOfLotto);
        List<Lotto> allLotto = Lotto.lottoFactory(numberOfLotto);
        OutputView.allLotto(allLotto);

        Lotto winningNumbers = new Lotto(InputView.winningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.bonusNumber());
        LottoResult lottoResult = new LottoResult(new WinningLotto(bonusNumber, winningNumbers).match(allLotto));

        OutputView.resultStartingPoint();
        OutputView.winningLottoCounts(lottoResult);
        OutputView.rateOfReturn(lottoResult.calculateRateOfReturn(totalPriceToBuyLotto));
    }
}
