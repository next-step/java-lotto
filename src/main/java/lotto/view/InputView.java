package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.List;

public interface InputView {
    int purchase();

	List<Lotto> manualLottos();

	WinningLotto winningLotto();
}
