package ui;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoGroup;
import domain.WinningLottoGroup;
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

        Integer bonusNum = Integer.parseInt(InputView.setBonusNumber());
        lastLotto.addNumber(bonusNum);

        WinningLottoGroup combineLottoGroup = LottoGame.getCombineLottos(lottoGroup, lastLotto);
        ResultView.viewStats();

        ResultView.printStats(combineLottoGroup);

        double totalEarningRate = LottoGame.getTotalEarningRate(price, combineLottoGroup.getTotalReward());
        ResultView.printResult(totalEarningRate);
    }
}
