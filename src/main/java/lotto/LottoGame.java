package lotto;

import lotto.domain.AutoLottoStrategy;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.domain.LottoFactory;

public class LottoGame {

    public static void main(String[] args) {
        LottoFactory.setLottoStrategy(new AutoLottoStrategy());
        Lottos lottos = LottoFactory.lottos(InputView.inputBuy());
        ResultView.printLottos(lottos);
        Winning winning = LottoFactory.winning(InputView.inputWinning());
        lottos.checkWinning(winning);

        ResultView.printResult(winning, lottos.getBuyNum());
    }

}
