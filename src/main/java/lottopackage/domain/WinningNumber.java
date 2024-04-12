package lottopackage.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumber {
    Set<LottoBall> winningNumber;
    LottoBall bonusBall;

    public WinningNumber(Set<LottoBall> winningNumber, LottoBall bonusBall) {
        isValidWinningNumber(winningNumber);
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    private static void isValidWinningNumber(Set<LottoBall> winningNumber) {
        if (winningNumber.size() != Lotto.getLottoSize()) {
            System.out.println(winningNumber.size());
            System.out.println(Lotto.getLottoSize());
            throw new IllegalArgumentException("당첨번호는 6자리 숫자여야 합니다.");
        }
    }

    public static Prize checkPrize(Set<LottoBall> lotto, WinningNumber winningNumber) {
        Set<LottoBall> lottoForPrizeCheck = new HashSet<>(lotto);

        lottoForPrizeCheck.removeAll(winningNumber.winningNumber);
        if (lottoForPrizeCheck.size() == 1) {
            return checkBonusBall(lottoForPrizeCheck, winningNumber.bonusBall);
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
