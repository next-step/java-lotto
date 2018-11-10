package ui;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoGroup;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

public class ConsoleUI {
    public static void main(String[] args) {
        int buyLottoCount = LottoGame.buyLottoCount(InputView.setLottoPayment());
        ResultView.printBuyLottoCount(buyLottoCount);

        LottoGroup lottoGroup = new LottoGroup(buyLottoCount);
        ResultView.printLottoGroup(lottoGroup);

        Lotto lastLotto = new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber()));
        LottoGroup combineLottoGroup = lottoGroup.getCombineLottos(lastLotto);
        ResultView.viewStats();

        combineLottoGroup.calculateCombine(lastLotto);
        ResultView.printStats(combineLottoGroup);

        double totalEarningRate = LottoGame.getTotalEarningRate(getPrice(buyLottoCount), combineLottoGroup.getTotalRewards());
        ResultView.printResult(totalEarningRate);
    }

    private static int getPrice(int buyLottoCount) {
        return buyLottoCount * Lotto.LOTTO_PRICE;
    }
}
