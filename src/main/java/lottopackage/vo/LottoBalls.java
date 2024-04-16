package lottopackage.vo;

import java.util.*;

public class LottoBalls {

    private static final int LOTTO_SIZE = 6;
    private final Set<LottoBall> lottoBalls;

    public LottoBalls() {
        Set<LottoBall> lottoBalls = new HashSet<>();
        while (lottoBalls.size() != LOTTO_SIZE) {
            lottoBalls.add(new LottoBall());
        }
        this.lottoBalls = lottoBalls;
    }

    public LottoBalls(Integer... numbers) {
        this(toLotto(numbers));
    }

    private static Set<LottoBall> toLotto(Integer... lottoBalls) {
        Set<LottoBall> lotto = new HashSet<>();
        for (Integer ball : lottoBalls) {
            lotto.add(new LottoBall(ball));
        }
        return lotto;
    }

    public LottoBalls(LottoBall... lottoBall) {
        this( new HashSet<>(Arrays.asList(lottoBall)) );
    }

    public LottoBalls(Set<LottoBall> lottoBalls) {
        isLottoValid(lottoBalls);
        this.lottoBalls = lottoBalls;
    }

    public Set<LottoBall> getLottoBalls() {
        return lottoBalls;
    }

    public static void isLottoValid(Set<?> lottoBalls) {
        if (lottoBalls.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBalls that = (LottoBalls) o;
        return Objects.equals(lottoBalls, that.lottoBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls);
    }

    @Override
    public String toString() {
        String lottoBalls = "[";

        Iterator<LottoBall> iteratorLotto = this.lottoBalls.iterator();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            String delimiter = (i == (LOTTO_SIZE - 1)) ? "" : ", ";
            lottoBalls += (iteratorLotto.next() + delimiter);
        }

        lottoBalls += "]";

        return lottoBalls;
    }
}
