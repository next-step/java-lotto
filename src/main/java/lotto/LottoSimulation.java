package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoSimulation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(2000000000, 1500000, 50000, 5000));

        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> myLottos = lottoMachine.issue(purchaseAmount);

        outputView.showPurchasedLottos(myLottos);

        String winningNumber = inputView.readWinningNumber();
        PrizeWinningResult result = lottoMachine.checkPrizeWinning(new Lottos(myLottos), new WinningNumber(winningNumber));

        outputView.showResult(result);
    }

}
