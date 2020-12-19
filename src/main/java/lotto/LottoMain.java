package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottos;
import lotto.util.InputUtil;
import lotto.view.DisplayView;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        InputView.showInputMoneyInfo();

        String money = InputUtil.inputMoney();

        int numberOfLotto = lottoMachine.buyLotto(money);
        DisplayView.exchangeLottoMsg(numberOfLotto);
        DisplayView.showLottoBuckets(lottoMachine.getLottoBuckets());

        InputView.showInputLastWinningNumber();
        String lastWinningNumbers = InputUtil.enterLastWinningNumbers();

        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoBuckets());
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers);

        DisplayView.showWinningStatis(winningLottos);
        DisplayView.printRevenu(winningLottos.calcurateRevenue(money));

    }
}
