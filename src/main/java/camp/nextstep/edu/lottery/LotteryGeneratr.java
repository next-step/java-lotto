package camp.nextstep.edu.lottery;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGeneratr {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;

    static Lottery create() {
        List<Integer> numbers = IntStream
            .rangeClosed(LOTTO_NUMBER_START, LOTTO_NUMBER_END)
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new Lottery(numbers.subList(0, LOTTO_NUMBER_COUNT));
    }
}
