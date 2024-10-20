package lotto.ui.input;

import lotto.model.Lotto;
import lotto.model.Price;

public interface InputView {
    Price readPrice();
    Lotto readWinningLotto();
}
