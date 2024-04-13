package lottopackage.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumberAndBonusBall {
    LottoBalls winningNumber;
    LottoBall bonusBall;

    public WinningNumberAndBonusBall(Set<LottoBall> winningNumber, LottoBall bonusBall) {
        this(new LottoBalls(winningNumber), bonusBall);
    }

    public WinningNumberAndBonusBall(LottoBalls winningNumber, LottoBall bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    public static Prize checkPrize(LottoBalls lottoBalls, WinningNumberAndBonusBall winningNumberAndBonusBall) {
        Set<LottoBall> lottoForPrizeCheck = new HashSet<>(lottoBalls.getLottoBalls());

        lottoForPrizeCheck.removeAll(winningNumberAndBonusBall.winningNumber.getLottoBalls());
        if (lottoForPrizeCheck.size() == 1) {
            return checkBonusBall(lottoForPrizeCheck, winningNumberAndBonusBall.bonusBall);
        }
        return Arrays.stream(Prize.values())
                .filter((prize) -> prize.getBall() == (6 - lottoForPrizeCheck.size()))
                .findFirst()
                .orElse(Prize.SIXTH);
    }

    private static Prize checkBonusBall(Set<LottoBall> lottoForPrizeCheck, LottoBall bonusBall) {
        Set<LottoBall> lottoForPrizeCheck2nd = new HashSet<>(lottoForPrizeCheck);
        lottoForPrizeCheck2nd.remove(bonusBall);
        boolean isBonusBallMatched = lottoForPrizeCheck2nd.isEmpty();
        return Arrays.stream(Prize.values())
                .filter((prize) -> prize.getBonusBall() == isBonusBallMatched)
                .filter((prize) -> prize.getBall() == (6 - lottoForPrizeCheck.size()))
                .findFirst()
                .orElse(Prize.THIRD);
    }
}
