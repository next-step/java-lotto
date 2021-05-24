package kr.insup.lotto.domain;

public class LottoPrizeSelector {

    private final Lotto winningNumber;
    private final Lotto userNumber;

    public LottoPrizeSelector(Lotto winningNumber, Lotto userNumber) {
        this.winningNumber = winningNumber;
        this.userNumber = userNumber;
    }

    public LottoPrize selectLottoPrize() {
        int match = 0;
        boolean isBonusBallMatch = false;

        for (Integer number : winningNumber.numbers()) {
            match = isUserNumberContainNumber(number, match);
        }

        if (match == 5) {
            isBonusBallMatch = userNumber.hasNumber(winningNumber.bonusNumber());
        }

        return LottoPrize.matchLottoPrize(match, isBonusBallMatch);
    }

    private int isUserNumberContainNumber(Integer number, int match) {
        if (userNumber.hasNumber(number)) {
            match++;
        }

        return match;
    }
}
