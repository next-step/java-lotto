package lottery.domain;

public class WinnerLottery {

    public static final int MATCH_COUNT = 1;
    public static final int DEFAULT_MATCH_COUNT = 0;

    private final LotteryNumbers winnerNumbers;
    private final BonusBall bonusBall;

    public WinnerLottery(LotteryNumbers winnerNumbers, BonusBall bonusBall) {
        this.winnerNumbers = winnerNumbers;

        validateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validateBonusBall(BonusBall bonusBall) {
        if (bonusBall.match(winnerNumbers)) {
            throw new IllegalArgumentException("보너스볼은 당첨 번호와 포함되면 안됩니다. : " + bonusBall);
        }
    }

    public int match(LotteryNumbers input) {
        return winnerNumbers.match(input);
    }

    public boolean matchBonusBall(LotteryNumbers lottery) {
        return bonusBall.match(lottery);
    }
}
