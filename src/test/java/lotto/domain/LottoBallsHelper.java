package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.LottoBall;
import lotto.domain.number.LottoBalls;

public class LottoBallsHelper {

    public static LottoBalls numbersToBalls(List<Integer> numbers) {
        return new LottoBalls(numbers.stream()
                .map(LottoBall::new)
                .collect(Collectors.toUnmodifiableList()));
    }
}
