package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.WinningLottos;
import lotto.util.InputUtil;
import lotto.view.DisplayView;

public class LottoMain {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        DisplayView.showInputMoneyInfo();

        String money = InputUtil.inputMoney();

        int numberOfLotto = lottoMachine.exchangeNumberOfLotto(money);
        DisplayView.exchangeLottoMsg(numberOfLotto);
        DisplayView.showLottoBuckets(lottoMachine.getLottoBuckets());

        DisplayView.showInputLastWinningNumber();
        String lastWinningNumbers = InputUtil.enterLastWinningNumbers();

        WinningLottos winningLottos = lottoMachine.checkWinningNumbers(lastWinningNumbers);
        DisplayView.showWinningStatis(winningLottos);

        DisplayView.printRevenu(winningLottos.calcurateRevenue(money));

    }
}
