package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Numbers;
import lotto.domain.WinningRanks;

public class LotteryMachine {

    private final WinningChecker winningChecker;

    public LotteryMachine(Lottos lottos, Numbers winningNumbers) {
        this.winningChecker = new WinningChecker(lottos, winningNumbers);
    }


    public WinningRanks getWinningRanks() {
        return new WinningRanks(this.winningChecker.getWinningRanks());
    }
}
