package step2.domain.lotto;

import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private static final int COUNT = NormalLotto.COUNT;
    private static final int COUNT_INCLUDING_BONUS = COUNT + 1;

    private final List<LottoBall> lottoBalls;
    private final LottoBall bonusBall;

    public WinningLotto(String rawNumbers, int bonusNumber) {
        this(LottoBall.balls(rawNumbers), new LottoBall(bonusNumber));
    }

    private WinningLotto(List<LottoBall> numbers, LottoBall bonusNumber) {
        if (!valid(numbers, bonusNumber)) {
            throw new CustomException(ErrorCode.INVALID_WINNING_LOTTO_NUMBERS);
        }
        this.lottoBalls = numbers;
        this.bonusBall = bonusNumber;
    }

    public int matchCount(NormalLotto lotto) {
        int count = 0;
        for (LottoBall lottoBall : lotto.getBalls()) {
            count += oneIfNumberMatch(lottoBall);
        }
        return count;
    }

    public boolean matchBonus(NormalLotto lotto) {
        boolean match = false;
        for (LottoBall lottoBall : lotto.getBalls()) {
            match |= bonus(lottoBall);
        }
        return match;
    }

    private boolean bonus(LottoBall lottoBall) {
        return this.bonusBall.equals(lottoBall);
    }

    private int oneIfNumberMatch(LottoBall lottoBall) {
        if (this.lottoBalls.contains(lottoBall)) {
            return 1;
        }
        return 0;
    }

    private static boolean valid(List<LottoBall> lottoBalls, LottoBall bonusBall) {
        return sizeSix(lottoBalls) && unique(lottoBalls, bonusBall);
    }

    private static boolean sizeSix(List<LottoBall> lottoBalls) {
        return lottoBalls.size() == COUNT;
    }

    private static boolean unique(List<LottoBall> numbers, LottoBall bonusBall) {
        HashSet<LottoBall> hashSet = new HashSet<>(numbers);
        hashSet.add(bonusBall);
        return hashSet.size() == COUNT_INCLUDING_BONUS;
    }

}
