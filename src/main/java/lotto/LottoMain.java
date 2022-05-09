package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.UserAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        UserAmount userAmount = InputView.inputUserAmount();

        int numberOfUserGenerateLotto = InputView.inputNumberOfUserGenerateLotto();

        String lottoOfUser = InputView.inputLottoOfUser(numberOfUserGenerateLotto);
        Lottos lottos = new Lottos(userAmount, lottoOfUser);
        OutputView.outputLottoNumbers(lottos);

        String previousWeekWinningNumber = InputView.inputPreviousWeekWinningNumber();
        LottoNumbers lottoNumbers = new LottoNumbers(previousWeekWinningNumber);
        String bonusBall = InputView.inputBonusBall();
        LottoNumber lottoNumber = new LottoNumber(bonusBall);

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, lottoNumber);

        OutputView.outputWinningStatistics(lottos, winningLotto);
        OutputView.outputRevenueRate(lottos, winningLotto);
    }
}
