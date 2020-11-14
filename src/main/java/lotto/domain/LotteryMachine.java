package lotto.domain;

public class LotteryMachine {

    private final Numbers numbers;

    public LotteryMachine(Numbers numbers) {
        this.numbers = numbers;
    }


    public WinningRanks checkLottos(Lottos lottos) {
        return lottos.checkWinningRanks(numbers);
    }
}
