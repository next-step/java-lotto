package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    public void pull() {
        int userAmount = InputView.inputUserAmount();

        Lottos lottos = new Lottos(userAmount);
        OutputView.outputLottoNumbers(lottos);

        String previousWeekWinningNumber = InputView.inputPreviousWeekWinningNumber();
        LottoNumbers lottoNumbers = new LottoNumbers(previousWeekWinningNumber);
        String bonusBall = InputView.inputBonusBall();
        LottoNumber lottoNumber = new LottoNumber(bonusBall);

        OutputView.outputWinningStatistics(lottos, lottoNumbers, lottoNumber);
        OutputView.outputRevenueRate(lottos, lottoNumbers, lottoNumber);
    }
}

