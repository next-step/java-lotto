package lotto.view;

import lotto.domain.dto.LottoBuyInfo;
import lotto.domain.dto.WinningLottoInfo;

public class FakeInputView implements InputView {
    private final LottoBuyInfo lottoBuyInfo;
    private final WinningLottoInfo winningLottoRequest;

    public FakeInputView(LottoBuyInfo lottoBuyInfo, WinningLottoInfo winningLottoRequest) {
        this.lottoBuyInfo = lottoBuyInfo;
        this.winningLottoRequest = winningLottoRequest;
    }

    @Override
    public LottoBuyInfo inputLottoBuyInfo() {
        return lottoBuyInfo;
    }

    @Override
    public WinningLottoInfo inputWinningLottoInfo() {
        return winningLottoRequest;
    }
}
