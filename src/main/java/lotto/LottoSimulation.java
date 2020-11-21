package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PrizeWinningResult;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoSimulation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();

        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> myLottos = lottoMachine.issue(purchaseAmount);

        outputView.showPurchasedLottos(myLottos);

        String winningNumber = inputView.readWinningNumber();
        int bonusNumber = inputView.readBonusNumber();
        PrizeWinningResult result = lottoMachine.checkPrizeWinning(new WinningNumber(winningNumber, bonusNumber), myLottos);

        outputView.showResult(result);
    }

}
