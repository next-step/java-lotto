package lotto;

import lotto.domain.LottoAutoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        int paying = InputView.inputMoney();

        int buyingCount = paying / LottoAutoMachine.PRICE;

        Lottos buyingLottos = LottoAutoMachine.makeLottos(buyingCount);
        ResultView.printBuyingLottos(buyingLottos);

        String[] winningNumbers = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusBall();

        WinningLotto winningLotto = makeWinningLotto(winningNumbers, bonusNumber);

        ResultView.printWinningStatistics(buyingLottos.getTotalRank(winningLotto), buyingLottos.getTotalWinningMoney(winningLotto), paying);
    }

    private static WinningLotto makeWinningLotto(String[] winningNumbers, int bonusNumber) {
        return new WinningLotto(Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()),
                bonusNumber);
    }

}

