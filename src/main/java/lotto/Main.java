package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;

public class Main {

    public static void main(String[] args) {
        Money lottoAmount = InputView.inputPrice();
        Lottos.initLottos(lottoAmount);

        Lotto winningLotto = InputView.inputWinningNumbers();
    }
}
