package lotto;

import lotto.domain.AutoLottoStrategy;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.domain.LottoFactory;

public class LottoGame {

    public static void main(String[] args) {
        LottoFactory.setLottoStrategy(new AutoLottoStrategy());
        LottoFactory.lottoNumbers();

        Lottos lottos = LottoFactory.lottos(InputView.inputBuy());
        ResultView.printLottos(lottos);
        WinningLotto winning = LottoFactory.winning(InputView.inputWinning());
        lottos.checkWinning(winning);

        ResultView.printResult(winning, lottos.getBuyNum());
    }

}
