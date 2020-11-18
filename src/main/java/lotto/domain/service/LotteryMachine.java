package lotto.domain.service;

import lotto.domain.repository.Lottos;
import lotto.domain.repository.Numbers;
import lotto.domain.repository.WinningRanks;

public class LotteryMachine {

    private final Numbers winningNumbers;

    public LotteryMachine(Numbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningRanks checkLottos(Lottos lottos) {
        return WinningChecker.checkWinningRanks(lottos, winningNumbers);
    }
}
