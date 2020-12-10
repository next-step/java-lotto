package lotto;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;


public class Main {
    public static void main(String[] args) {

        String money = InputView.inputMoney();
        Lottos lottos = Shop.buyLottos(money);
        OutputView.printPurchaseLottos(lottos);

        LottoAdmin lottoAdmin = new LottoAdmin(InputView.inputWinningLotto());
        Result result = new Result();
        for(Lotto lotto : lottos.getLottos()) {
            result.add(lottoAdmin.calculateRank(lotto));
        }
        OutputView.printWinningStatistics(result);
        OutputView.printWinningRatio(result, Long.parseLong(money));
    }
}
