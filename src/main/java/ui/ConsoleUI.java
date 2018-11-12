package ui;

import domain.*;
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

        Integer bonusNum = Integer.parseInt(InputView.setBonusNumber());
        WinningLotto winningLotto = new WinningLotto(StringUtils.convertStrToNum(InputView.lastLottoNumber()), bonusNum);
        WinningLottoGroup combineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
        ResultView.viewStats();
        ResultView.printStats(combineLottoGroup);

        double totalEarningRate = LottoGame.getTotalEarningRate(price, combineLottoGroup);
        ResultView.printResult(totalEarningRate);
    }
}
