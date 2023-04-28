package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = InputView.buy();
        Lotto lotto = new Lotto(inputView.getMoney());
    }
}
