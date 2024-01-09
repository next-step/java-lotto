package lotto.controller;

import java.util.List;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        Money totalPriceToBuyLotto = InputView.totalPrice();
        int numberOfLotto = totalPriceToBuyLotto.calculateNumberOfTicket();
        int manualLottoCount = InputView.manualLottoCount();
        List<Lotto> allLotto = Lotto.lottoFactoryForManual(InputView.manualLottos(manualLottoCount));

        int autoLottoCount = numberOfLotto - manualLottoCount;
        OutputView.numberOfLotto(manualLottoCount, autoLottoCount);
        allLotto.addAll(Lotto.lottoFactoryForAuto(autoLottoCount));
        System.out.println(allLotto.size());
        OutputView.allLotto(allLotto);

        Lotto winningNumbers = InputView.winningNumber();
        LottoNumber bonusNumber = InputView.bonusNumber();
        LottoResult lottoResult = new WinningLotto(winningNumbers, bonusNumber).match(allLotto);

        OutputView.resultStartingPoint();
        OutputView.winningLottoCounts(lottoResult);
        OutputView.rateOfReturn(totalPriceToBuyLotto.calculateRateOfReturn(lottoResult));
    }
}
