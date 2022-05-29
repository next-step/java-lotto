package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        int paying = InputView.inputMoney();

        Lottos buyingLottos = LottoAutoMachine.makeLottos(paying);
        ResultView.printBuyingLottos(buyingLottos);

        String[] winningNumbers = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusBall();

        WinningLotto winningLotto = makeWinningLotto(winningNumbers, bonusNumber);

        ResultView.printWinningStatistics(new TotalRank(winningLotto, buyingLottos), buyingLottos.getTotalWinningMoney(winningLotto), paying);
    }

    private static WinningLotto makeWinningLotto(String[] winningNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList())),
                bonusNumber);
    }

}

