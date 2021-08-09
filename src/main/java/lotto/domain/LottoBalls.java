package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoBalls {
    private final static int LOTTO_BALLS_MAX_NUM = 6;

    private final Set<LottoBall> lottoBalls;

    private LottoBalls(int... numbers) {
        this.lottoBalls = Arrays.stream(numbers)
            .mapToObj(LottoBall::select)
            .collect(Collectors.toSet());
        validate();
    }

    public static LottoBalls of(int... numbers) {
        return new LottoBalls(numbers);
    }

    public static LottoBalls createRandomNumber() {
        List<Integer> randomNumbers = IntStream
            .rangeClosed(LottoBall.LOTTO_BALL_NUMBER_MIN, LottoBall.LOTTO_BALL_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);
        randomNumbers = randomNumbers.subList(0, LOTTO_BALLS_MAX_NUM).stream()
            .sorted()
            .collect(Collectors.toList());

        return LottoBalls.of(randomNumbers.stream()
            .mapToInt(Integer::intValue)
            .toArray());
    }

    private void validate() {
        if (lottoBalls.size() != LOTTO_BALLS_MAX_NUM) {
            throw new RuntimeException("로또공의 개수를 만족하지 않습니다.");
        }
    }

    private boolean contains(int number) {
        return lottoBalls.stream()
            .anyMatch(lottoBall -> lottoBall.equals((LottoBall.select(number))));
    }

    public int countMatchNumber(LottoBalls winnerNumbers) {
        return (int)winnerNumbers.getLottoBallsStream()
            .filter(winnerNumber -> this.contains(winnerNumber.number()))
            .count();
    }

    public Stream<LottoBall> getLottoBallsStream() {
        return lottoBalls.stream();
    }
}

