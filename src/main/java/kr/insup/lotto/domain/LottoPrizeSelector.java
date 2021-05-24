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

        for (Integer number : winningNumber.numbers()) {
            match = isWinningNumberContainNumber(number, match);
        }

        return LottoPrize.matchLottoPrize(match);
    }

    private int isWinningNumberContainNumber(Integer number, int match) {
        if (userNumber.hasNumber(number)) {
            match++;
        }

        return match;
    }
}
