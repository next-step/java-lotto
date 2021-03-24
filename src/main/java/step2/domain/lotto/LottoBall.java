package step2.domain.lotto;

import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBall {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private final int number;

    public LottoBall(int number) {
        if (!valid(number)) {
            throw new CustomException(ErrorCode.INVALID_LOTTO_NUMBER);
        }
        this.number = number;
    }

    public static List<LottoBall> balls(int count) {
        if (!valid(count)) {
            throw new CustomException(ErrorCode.INVALID_NUMBER_OF_LOTTO_BALLS);
        }
        return IntStream.rangeClosed(1, UPPER_BOUND)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoBall::shuffleList))
                .subList(0, count)
                .stream()
                .sorted()
                .map(LottoBall::new)
                .collect(Collectors.toList());
    }

    private static List<Integer> shuffleList(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    public static List<LottoBall> balls(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(LottoBall::new)
                .collect(Collectors.toList());
    }

    private static boolean valid(int number) {
        return number >= LOWER_BOUND && number <= UPPER_BOUND;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoBall lottoBall = (LottoBall) object;
        return number == lottoBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
