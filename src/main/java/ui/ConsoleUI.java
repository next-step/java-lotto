package ui;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoGroup;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

public class ConsoleUI {
    public static void main(String[] args) {
        int price = InputView.setLottoPayment();
        int buyLottoCount = LottoGame.buyLottoCount(price);
        ResultView.printBuyLottoCount(buyLottoCount);

        LottoGroup lottoGroup = new LottoGroup(buyLottoCount);
        ResultView.printLottoGroup(lottoGroup);

        Lotto lastLotto = new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber()));
        LottoGroup combineLottoGroup = LottoGame.getCombineLottos(lottoGroup, lastLotto);
        ResultView.viewStats();

        combineLottoGroup.calculateCombine(lastLotto);
        ResultView.printStats(combineLottoGroup);

        double totalEarningRate = LottoGame.getTotalEarningRate(price, combineLottoGroup.getTotalRewards());
        ResultView.printResult(totalEarningRate);
    }
}
