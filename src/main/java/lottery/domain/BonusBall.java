package lottery.domain;

public class BonusBall {

    private final LotteryNumber bonusBallNumber;

    private BonusBall(LotteryNumber bonusBallNumber) {
        this.bonusBallNumber = bonusBallNumber;
    }

    public static BonusBall of(int bonusBallNumber, LotteryTicket lastWinnerTicket) {
        validateBonusBallNumber(bonusBallNumber, lastWinnerTicket);
        return new BonusBall(LotteryNumber.from(bonusBallNumber));
    }

    private static void validateBonusBallNumber(int bonusBallNumber, LotteryTicket lastWinnerTicket) {
        if (lastWinnerTicket.isContainingLotteryNumber(bonusBallNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_BALL_NUMBER);
        }
    }
}
