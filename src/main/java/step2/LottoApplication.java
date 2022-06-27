package step2;

import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int payedPrice = InputView.inputPrice();
        List<Lotto> lottos = LottoStore.purchaseLotto(payedPrice);
        ResultView.showLottos(lottos);
        Lotto winningLotto = InputView.inputWinningLottoNumber();
        ResultView.printResult(lottos, winningLotto, payedPrice);
    }

}
