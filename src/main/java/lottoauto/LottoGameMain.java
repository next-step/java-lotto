package lottoauto;

import lottoauto.domain.Lotto;
import lottoauto.domain.Lottos;
import lottoauto.domain.RatingStatics;
import lottoauto.domain.WinningLotto;
import lottoauto.view.InputView;
import lottoauto.view.ResultView;

public class LottoGameMain {
    public static void main(String[] args) {
        Lottos lottos = Lottos.from(InputView.inputPurchaseAmount());
        ResultView.printLottosInfo(lottos);

        Lotto winningLotto = Lotto.from(InputView.inputWinningNumbers());
        RatingStatics ratingStatics = lottos.findRatingStatics(WinningLotto.from(winningLotto));
        ResultView.printRatingStatics(ratingStatics);
        ResultView.printRateOfReturn(ratingStatics.rateOfReturn(lottos.totalPrice()));
    }
}
