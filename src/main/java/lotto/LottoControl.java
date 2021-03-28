package lotto;

import lotto.domain.*;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoControl {
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int money = View.purchaseAmount(scanner);

        int numberOfManualGames = View.numberOfManualGames(scanner);
        List<String> manualGameNumbers = View.manualGameNumbers(numberOfManualGames, scanner);

        Lotto lotto = new Lotto(money, manualGameNumbers, new RandomLottoNumberGenerator());
        View.print(lotto);

        LottoGame typedWinningNumber = new LottoGame(View.winningNumber(scanner));
        int typedBonusNumber = View.bonusNumber(scanner);
        WinningNumber winningNumber = new WinningNumber(typedWinningNumber, typedBonusNumber);

        Winners winners = lotto.winners(winningNumber);
        View.printStatsHead();
        Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch() != 0)
                .forEach(rank -> View.print(rank, winners.wins(rank)));
        View.printYield(winners.yield(money));
    }
}
