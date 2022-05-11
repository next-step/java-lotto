package lottoauto;

import lottoauto.domain.*;
import lottoauto.view.InputView;
import lottoauto.view.ResultView;

public class LottoGameMain {
    public static void main(String[] args) {
        // 구입금액 및 수동으로 구매할 로또 수 입력
        int purchasedAmount = InputView.inputPurchaseAmount();
        int theNumberOfManualLottos = InputView.inputTheNumberOfManualLottos();

        // 수동으로 구매할 번호를 입력
        Lottos lottos = Lottos.of(
                purchasedAmount,
                InputView.inputManualLottos(theNumberOfManualLottos)
        );

        // 구매한 로또 생성 결과 출력
        ResultView.printLottosInfo(lottos, theNumberOfManualLottos);

        // 지난 주 당첨 번호 입력 및 보너스 번호 입력
        WinningLotto winningLotto = WinningLotto.of(
                Lotto.from(InputView.inputWinningNumbers()),
                LottoNumber.from(InputView.inputBonusNumber())
        );

        // 당첨 통계 및 총 수익률 출력
        RatingStatics ratingStatics = lottos.findRatingStatics(winningLotto);
        ResultView.printRatingStatics(ratingStatics);
        ResultView.printRateOfReturn(ratingStatics.rateOfReturn(lottos.totalPrice()));
    }
}
