package step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public static final String VALID_LOTTO_COUNT_MSG = "로또 번호는 6개여야 합니다.";
    private static final String COMMA = ",";
    private static final int LOTTO_COUNT = 6;

    private Set<Ball> balls = new TreeSet<>();

    public Lotto(List<Ball> numbers) {
        for (Ball number : numbers) {
            balls.add(number);
        }
        validLottoCount();
    }

    public Lotto(String numbers) {
        this(Arrays.stream(numbers.split(COMMA)).map(ball -> new Ball(ball)).collect(Collectors.toList()));
    }

    private void validLottoCount() {
        if (balls.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(VALID_LOTTO_COUNT_MSG);
        }
    }

    public int getMatchCount(Lotto targetLotto) {
        int matchCount = 0;
        for (Ball ball : targetLotto.balls) {
            matchCount = calcMatchCount(matchCount, ball);
        }
        return matchCount;
    }

    private int calcMatchCount(int matchCount, Ball ball) {
        if (balls.contains(ball)) {
            matchCount++;
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return balls.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return balls.equals(lotto.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
