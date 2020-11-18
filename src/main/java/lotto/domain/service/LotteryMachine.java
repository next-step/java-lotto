package lotto.domain.service;

import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.repository.WinningRanks;

public class LotteryMachine {

    private final WinningChecker winningChecker;

    public LotteryMachine(Lottos lottos, Numbers winningNumbers) {
        this.winningChecker = new WinningChecker(lottos, winningNumbers);
    }


    public WinningRanks getWinningRanks() {
        return new WinningRanks(this.winningChecker.getWinningRanks());
    }
}
