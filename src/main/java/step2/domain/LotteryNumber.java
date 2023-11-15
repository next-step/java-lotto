package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumber {

    private List<Integer> numbers;

    public LotteryNumber() {
        this.numbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }

    public List<Integer> createLotteryNumber() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(6).collect(Collectors.toList());
    }
}
