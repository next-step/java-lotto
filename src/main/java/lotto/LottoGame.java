package lotto;

import lotto.domain.AutoLottoStrategy;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.util.InputView;
import lotto.util.LottoFactory;
import lotto.util.ResultView;

public class LottoGame {

    public static void main(String[] args) {
        Lottos lottos = LottoFactory.lottos(InputView.inputBuy(), new AutoLottoStrategy());
        Winning winning = LottoFactory.winning(InputView.inputWinning());
        lottos.checkWinning(winning);

        ResultView.printResult(winning, lottos.getBuyNum());
    }

}
