package lotto;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        String money = InputView.inputMoney();
        List<Lotto> lottos = Shop.buyLottos(money);
        OutputView.printPurchaseLottos(lottos);

        LottoAdmin lottoAdmin = new LottoAdmin(InputView.inputWinningLotto());
        Result result = new Result();
        for(Lotto lotto : lottos) {
            result.add(lottoAdmin.calculateRank(lotto));
        }
        OutputView.printWinningStatistics(result);
        OutputView.printWinningRatio(result, Long.parseLong(money));
    }
}
