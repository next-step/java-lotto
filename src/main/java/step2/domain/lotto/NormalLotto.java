package step2.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public NormalLotto(List<LottoBall> lottoBalls) {
        if (!valid(lottoBalls)) {
            Logger logger = Logger.getGlobal();
            logger.log(Level.SEVERE, "Lotto balls are not six or they are not unique");
            throw new IllegalArgumentException("Lotto balls are not six or they are not unique");
        }
        this.balls = lottoBalls;
    }

    public List<LottoBall> getBalls() {
        return balls;
    }

    public boolean valid(List<LottoBall> lottoBalls) {
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
