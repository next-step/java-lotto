package lotto.view;

import lotto.domain.dto.LottoBuyInfo;
import lotto.domain.dto.WinningLottoInfo;

public interface InputView {
    LottoBuyInfo inputLottoBuyInfo();

    WinningLottoInfo inputWinningLottoInfo();
}
