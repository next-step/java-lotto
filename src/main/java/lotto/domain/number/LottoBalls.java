package lotto.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.exception.InvalidLottoBallsException;

public class LottoBalls {

    private static final int LOTTO_BALLS_SIZE = 6;
    private final Set<LottoBall> balls;

    public LottoBalls(List<LottoBall> lottoBallList) {
        if (lottoBallList == null) {
            throw new InvalidLottoBallsException(LOTTO_BALLS_SIZE);
        }

        Set<LottoBall> lottoBallSet = new HashSet<>(lottoBallList);

        if (lottoBallSet.size() != LOTTO_BALLS_SIZE || lottoBallSet.size() < lottoBallList.size()) {
            throw new InvalidLottoBallsException(LOTTO_BALLS_SIZE);
        }

        this.balls = lottoBallSet;
    }

    public static int getBallsSize() {
        return LOTTO_BALLS_SIZE;
    }

    public List<LottoBall> getBalls() {
        return balls.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isContain(LottoBall lottoBall) {
        return balls.contains(lottoBall);
    }
}
