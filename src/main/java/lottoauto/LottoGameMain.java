package lottoauto;

import lottoauto.domain.*;
import lottoauto.view.InputView;
import lottoauto.view.ResultView;

public class LottoGameMain {
    public static void main(String[] args) {
        // 로또 구입금액 입력 후 해당 금액만큼 로또 발급
        Lottos lottos = Lottos.from(InputView.inputPurchaseAmount());
        ResultView.printLottosInfo(lottos);

        // 지난 주 당첨 번호 입력 및 보너스 번호 입력
        WinningLotto winningLotto = WinningLotto.of(
                Lotto.from(InputView.inputWinningNumbers()),
                LottoNumber.from(InputView.inputBonusNumber())
        );
        RatingStatics ratingStatics = lottos.findRatingStatics(winningLotto);

        // 당첨 통계 및 총 수익률 출력
        ResultView.printRatingStatics(ratingStatics);
        ResultView.printRateOfReturn(ratingStatics.rateOfReturn(lottos.totalPrice()));
    }
}
