package lotto;

import lotto.domain.*;
import lotto.domain.dto.RanksDto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.readMoney();
        int manualCount = InputView.readManualCount();
        List<String> manualNumbers = InputView.readManualNumbers(manualCount);

        LottoBuyMethod lottoBuyMethod = new LottoBuyMethod(money, manualNumbers);
        Lottos lottos = lottoBuyMethod.buy();

        ResultView.printBuyHistory(lottoBuyMethod, lottos);

        String winningNumber = InputView.readWinningNumber();
        int bonusNumber = InputView.readBonusNumber();
        WinLotto winLotto = new WinLotto(new Lotto(winningNumber), LottoNumber.valueOf(bonusNumber));

        Ranks ranks = lottos.checkWinning(winLotto);
        ResultView.printResult(new RanksDto(ranks));
    }

}
