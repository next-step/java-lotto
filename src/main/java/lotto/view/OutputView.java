package lotto.view;

import lotto.domain.LottoGameCount;
import lotto.domain.Lottoes;

import static lotto.utils.Constants.MSG_LOTTO_COUNT;

public class OutputView {
    public void drawLottoGameCount(LottoGameCount lottoGameCount) {
        System.out.println(lottoGameCount.getLottoGameCount() + MSG_LOTTO_COUNT);
    }

    public void drawPurchasedLottoes(Lottoes lottoes) {
        lottoes.getLottoGames().forEach(lottoGame ->
                System.out.println(lottoGame.getLottoNumbers().getLottoNumbers()));
        System.out.println();
    }

}
