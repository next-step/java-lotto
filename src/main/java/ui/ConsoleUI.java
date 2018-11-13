package ui;

import domain.*;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

public class ConsoleUI {
    public static void main(String[] args) {
        //구입금액입력
        int price = InputView.setLottoPayment();
        int buyLottoCount = LottoGame.buyLottoCount(price);
        ResultView.printBuyLottoCount(buyLottoCount);
        //구매한 로또목록
        LottoGroup lottoGroup = new LottoGroup(buyLottoCount);
        ResultView.printLottoGroup(lottoGroup);
        //1등로또생성
        Integer bonusNum = Integer.parseInt(InputView.setBonusNumber());
        WinningLotto winningLotto = new WinningLotto(new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber())), bonusNum);
        //당첨된 로또결과 생성
        LottoResultGroup combineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
        ResultView.viewStats();
        ResultView.printStats(combineLottoGroup);
        //수익률 출력
        int totalRewards = combineLottoGroup.getTotalReward();
        double totalEarningRate = LottoGame.getTotalEarningRate(price, totalRewards);
        ResultView.printResult(totalEarningRate);
    }
}
