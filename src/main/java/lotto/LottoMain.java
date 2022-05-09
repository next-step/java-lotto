package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.UserAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        UserAmount userAmount = InputView.inputUserAmount();
        int numberOfUserGenerateLotto = InputView.inputNumberOfUserGenerateLotto();

        List<LottoNumbers> lottoOfUser = InputView.inputLottoOfUser(numberOfUserGenerateLotto);
        Lottos lottos = new Lottos(userAmount, lottoOfUser);
        OutputView.outputLottoNumbers(lottos);

        LottoNumbers lottoNumbers = InputView.inputPreviousWeekWinningNumber();
        LottoNumber bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusBall);

        OutputView.outputWinningStatistics(lottos, winningLotto);
        OutputView.outputRevenueRate(lottos, winningLotto);
    }
}
