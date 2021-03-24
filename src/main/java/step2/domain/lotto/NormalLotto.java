package step2.domain.lotto;

import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import java.util.HashSet;
import java.util.List;

public class NormalLotto {

    public static final int PRICE = 1000;
    public static final int COUNT = 6;

    private final List<LottoBall> balls;

    public NormalLotto() {
        this(LottoBall.balls(COUNT));
    }

    public NormalLotto(String rawLottoNumbers) {
        this(LottoBall.balls(rawLottoNumbers));
    }

    private NormalLotto(List<LottoBall> lottoBalls) {
        if (!valid(lottoBalls)) {
            throw new CustomException(ErrorCode.DUPLICATED_OR_ABNORMAL_NUMBER_OF_LOTTO_BALLS);
        }
        this.balls = lottoBalls;
    }

    public List<LottoBall> getBalls() {
        return balls;
    }

    private boolean valid(List<LottoBall> lottoBalls) {
        return sizeSix(lottoBalls) && unique(lottoBalls);
    }

    private static boolean sizeSix(List<LottoBall> lottoBalls) {
        return lottoBalls.size() == COUNT;
    }

    private boolean unique(List<LottoBall> lottoBalls) {
        return new HashSet<>(lottoBalls).size() == COUNT;
    }

    @Override
    public String toString() {
        return "" + balls;
    }
}
