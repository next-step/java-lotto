package ui;

import domain.Lotto;
import domain.LottoGame;
import domain.Lottos;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

public class ConsoleUI {
    public static void main(String[] args) {
        int buyLottoCount = LottoGame.buyLottoCount(InputView.setLottoPayment());
        ResultView.printBuyLottoCount(buyLottoCount);

        Lottos lottos = new Lottos(buyLottoCount);
        Lotto lastLotto = new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber()));
        Lottos combineLottos = lottos.getCombineLottos(lastLotto);
        ResultView.viewStats();

        combineLottos.calculateCombine(lastLotto);
        double totalEarningRate = LottoGame.getTotalEarningRate(lottos.getPrice(), combineLottos.getTotalRewards());
        ResultView.printResult(totalEarningRate);
    }
}
