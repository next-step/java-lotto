package lotto;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Long money = InputView.inputMoney();
        List<Lotto> lottos = Shop.buyLottos(money);
        OutputView.printPurchaseLottos(lottos);

        Lotto winningLotto = new Lotto(InputView.inputWinningLotto());
        Result result = new Result();
        for(Lotto lotto : lottos) {
            result.add(winningLotto.calculateRank(lotto));
        }
        OutputView.printWinningStatistics(result);
        OutputView.printWinningRatio(result, money);
    }
}
