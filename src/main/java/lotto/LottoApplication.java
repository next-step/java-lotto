package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        //로또 구매
        LottoShop lottoShop = new LottoShop(InputView.inputPurchaseAmount());
        Lottos lottos = lottoShop.getLottos();

        //구입 결과 출력
        OutputView.printPurchase(lottos);

        //당첨 로또 생성
        Lotto winningLotto = Lotto.of(InputView.inputWinningNumbers());

        //당첨 번호 비교 및 결과 출력
        lottos.checkLottosWinning(winningLotto);
        OutputView.printLottosResult(lottos);

    }
}
