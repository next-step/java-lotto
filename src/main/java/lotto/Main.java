package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        Money lottoAmount = InputView.inputPrice();
        OutputView.printLottoQuantity(lottoAmount);

        Lottos lottos = Lottos.initLottos(lottoAmount);
        OutputView.printLottos(lottos);

        Lotto winningLotto = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        checkContainsNumber(winningLotto, bonusNumber);

        Winners winners = lottos.findStatistics(winningLotto, bonusNumber);
        OutputView.printResult(winners, lottoAmount);
    }

    private static void checkContainsNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("이미 당첨번호에 있습니다.");
        }
    }
}
