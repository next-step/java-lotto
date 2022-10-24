package lotto.domain.number;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lotto.domain.exception.InvalidLottoNumberException;

public class LottoBall implements Comparable<LottoBall> {

    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 45;

    private final int number;

    private static final Map<Integer, LottoBall> BUCKET;

    static {
        BUCKET = new HashMap<>();
        for (int i = FIRST_NUMBER; i <= LAST_NUMBER; i++) {
            BUCKET.put(i, new LottoBall(i));
        }
    }

    private LottoBall(int number) {
        this.number = number;
    }

    public static LottoBall of(int number) {
        if (number < FIRST_NUMBER || number > LAST_NUMBER) {
            throw new InvalidLottoNumberException(FIRST_NUMBER, LAST_NUMBER);
        }
        return BUCKET.get(number);
    }

    public static int getFirstOfNumberRange() {
        return FIRST_NUMBER;
    }

    public static int getLastOfNumberRange() {
        return LAST_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoBall lottoBall = (LottoBall) obj;
        return this.number == lottoBall.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoBall o) {
        return Integer.compare(this.number, o.getNumber());
    }
}
