package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoSimulation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();

        int purchaseAmount = inputView.readPurchaseAmount();
        List<String> lottoNumbers = inputView.readLottoNumbers();

        List<Lotto> myLottos = lottoMachine.issue(purchaseAmount, lottoNumbers);
        outputView.showPurchasedLottos(myLottos);

        String winningNumber = inputView.readWinningNumber();
        int bonusNumber = inputView.readBonusNumber();
        PrizeWinningResult result = lottoMachine.checkPrizeWinning(new WinningNumbers(winningNumber, bonusNumber), myLottos);

        outputView.showResult(result);
    }

}
