package lotto.view;

import lotto.domain.dto.WinningLottoRequest;

public class FakeInputView implements InputView {
    private final long longMoney;
    private final WinningLottoRequest winningLottoRequest;

    public FakeInputView(long longMoney, WinningLottoRequest winningLottoRequest) {
        this.longMoney = longMoney;
        this.winningLottoRequest = winningLottoRequest;
    }

    @Override
    public long inputMoney() {
        return longMoney;
    }

    @Override
    public WinningLottoRequest inputWinningLotto() {
        return winningLottoRequest;
    }
}
