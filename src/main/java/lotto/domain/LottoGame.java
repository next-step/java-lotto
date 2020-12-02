package lotto.domain;

import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public void run() {
        InputMoney money = new InputMoney(InputView.inputMoney());
        System.out.println(money.getAvailableLottoSize() + "개를 구매했습니다.");
        List<Lotto> myLottoList = LottoUtil.createAutoLottoList(money);
        ResultView.printLotto(myLottoList);
        WinningResult winningResult = new WinningResult(InputView.inputWinningNumber());
        ResultView.printWinningStatistics(money, myLottoList, winningResult);
    }


}
