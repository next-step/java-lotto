package lotto.domain;

public class LotteryMachine {

    private final Numbers winningNumbers;

    public LotteryMachine(Numbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningRanks checkLottos(Lottos lottos) {
        return WinningChecker.checkWinningRanks(lottos, winningNumbers);
    }
}
