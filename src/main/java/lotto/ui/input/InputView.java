package lotto.ui.input;

import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.WinningLotto;

public interface InputView {
    Price readPrice();
    WinningLotto readWinningLotto();
}
