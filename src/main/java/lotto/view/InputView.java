package lotto.view;

import lotto.domain.dto.WinningLottoRequest;

public interface InputView {
    long inputMoney();

    WinningLottoRequest inputWinningLotto();
}
