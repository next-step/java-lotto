package lotto;

import calculator.util.NumberUtil;
import lotto.domain.*;
import lotto.util.InputUtil;
import lotto.view.DisplayView;
import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        InputView.showInputMoneyInfo();

        String money = InputUtil.inputMoney();
        lottoMachine.inputMoney(money);
        DisplayView.showManualLotto();
        String manualLottoSizeStr = InputUtil.enterManualLottoSize();
        int manualLottoSizeNumber = NumberUtil.stringToInt(manualLottoSizeStr);
        DisplayView.inputManualLottoNumber();

        for( int i = 0; i<manualLottoSizeNumber ; i++) {
            String inputManualLottoNumber = InputUtil.inputManualLottoNumber();
            lottoMachine.buyManualLotto(inputManualLottoNumber);
        }
        LottoBucket lottoBucket = lottoMachine.buyAutoLotto();

        DisplayView.exchangeLottoMsg(lottoBucket.countOfManualLotto(),lottoBucket.countOfAutoLotto());
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
