package lotto.domain;

public class LotteryMachine {

    private final Numbers numbers;

    public LotteryMachine(Numbers numbers) {
        this.numbers = numbers;
    }

    public WinningRank checkWinningRank(Numbers numbers) {
        return WinningRank.getWinningRank(this.numbers.countSameNumber(numbers));
    }
}
