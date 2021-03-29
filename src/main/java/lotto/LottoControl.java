package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;

public class LottoControl {
    public void play() {

        PurchaseAmount purchaseAmount = new PurchaseAmount(View.purchaseAmount());
        int numberOfManualGames = View.numberOfManualGames();

        List<String> manualGameNumbers = View.manualGameNumbers(numberOfManualGames);
        Lotto lotto = new Lotto(purchaseAmount, manualGameNumbers, new RandomLottoNumberGenerator());
        View.print(lotto);

        LottoGame typedWinningNumber = new LottoGame(View.winningNumber());
        int typedBonusNumber = View.bonusNumber();
        WinningNumber winningNumber = new WinningNumber(typedWinningNumber, typedBonusNumber);

        Winners winners = lotto.winners(winningNumber);
        View.printStatsHead();

        Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch() != 0)
                .forEach(rank -> View.print(rank, winners.wins(rank)));
        View.printYield(winners.yield(purchaseAmount));
    }
}
