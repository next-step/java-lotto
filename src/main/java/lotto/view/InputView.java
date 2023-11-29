package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public interface InputView {
    int purchase();

    WinningLotto winningLotto();
}
