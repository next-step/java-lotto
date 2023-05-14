package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final Integer RANDOM_MIN = 1;
    private static final Integer RANDOM_MAX = 43;
    private static final int NUMBER_PER_TICKET = 6;
    private static final List<LotteryNumber> numbers = IntStream.rangeClosed(RANDOM_MIN, RANDOM_MAX)
            .boxed().map(LotteryNumber::of).collect(Collectors.toList());

    @Override
    public Set<LotteryNumber> generate() {
        List<LotteryNumber> newNumbers = new ArrayList<>(numbers);
        Collections.shuffle(newNumbers);
        Set<LotteryNumber> result = new HashSet<>(newNumbers.subList(0, NUMBER_PER_TICKET));
        validate(result);
        return result;
    }

    private void validate(Set<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET || numbers.stream().distinct().count() != NUMBER_PER_TICKET) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }

}
