package kr.insup.lotto.domain;

public class LottoPrizeSelector {

    private final WinningLotto winningNumber;
    private final Lotto userNumber;

    public LottoPrizeSelector(WinningLotto winningNumber, Lotto userNumber) {
        this.winningNumber = winningNumber;
        this.userNumber = userNumber;
    }

    public LottoPrize selectLottoPrize() {
        int match = 0;
        boolean isBonusBallMatch = false;

        for (LottoNumber number : winningNumber.winningNumbers()) {
            match = isUserNumberContainNumber(number, match);
        }

        if (match == 5) {
            isBonusBallMatch = userNumber.hasNumber(winningNumber.bonusNumber());
        }

        return LottoPrize.matchLottoPrize(match, isBonusBallMatch);
    }

    private int isUserNumberContainNumber(LottoNumber number, int match) {
        if (userNumber.hasNumber(number)) {
            match++;
        }

        return match;
    }
}
