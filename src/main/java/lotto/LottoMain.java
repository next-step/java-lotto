package lotto;

import lotto.domain.*;
import lotto.util.InputUtil;
import lotto.view.DisplayView;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        InputView.showInputMoneyInfo();

        String money = InputUtil.inputMoney();

        LottoBucket lottoBucket = lottoMachine.buyLotto(money);
        int createLottoBucketCount = lottoBucket.getLottos().size();
        DisplayView.exchangeLottoMsg(createLottoBucketCount);
        DisplayView.showLottoBuckets(lottoMachine.getLottoBuckets());

        InputView.showInputLastWinningNumber();
        String lastWinningNumbers = InputUtil.enterLastWinningNumbers();

        InputView.showInputBonusNumber();
        String inputBonusNumber = InputUtil.enterBonusNumber();
        BonusNumber bonusNumber = new BonusNumber( lastWinningNumbers,inputBonusNumber);

        LottoResult lottoResult = new LottoResult(lottoMachine.getLottoBuckets());
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers, bonusNumber);

        DisplayView.showWinningStatics(winningLottos);
        DisplayView.printRevenu(winningLottos.calcurateRevenue(money));

    }
}
