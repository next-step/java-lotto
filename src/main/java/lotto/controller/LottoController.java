package lotto.controller;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        int totalPriceToBuyLotto = InputView.totalPrice();
        int numberOfLotto = totalPriceToBuyLotto / 1000;
        OutputView.numberOfLotto(numberOfLotto);
        List<LottoNumbers> allLottoNumbers = LottoNumbers.create(numberOfLotto);
        OutputView.allLottoNumbers(allLottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.bonusNumber());
        LottoResult lottoResult = new LottoResult(allLottoNumbers, new WinningNumbers(bonusNumber, winningNumbers));

        OutputView.resultStartingPoint();
        OutputView.winningLottoCounts(lottoResult);
        OutputView.rateOfReturn(lottoResult.calculateRateOfReturn(totalPriceToBuyLotto));
    }
}
