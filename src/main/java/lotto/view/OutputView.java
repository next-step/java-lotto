package lotto.view;

import lotto.domain.LottoGameCount;

import static lotto.utils.Constants.MSG_LOTTO_COUNT;

public class OutputView {
    public void drawLottoGameCount(LottoGameCount lottoGameCount) {
        System.out.println(lottoGameCount.getLottoGameCount() + MSG_LOTTO_COUNT);
    }
}
