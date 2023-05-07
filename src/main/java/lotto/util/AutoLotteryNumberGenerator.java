package lotto.util;

import lotto.model.LotteryNumber;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class AutoLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final Integer RANDOM_MAX = 43;
    private static final int NUMBER_PER_TICKET = 6;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public Set<LotteryNumber> generate() {
        Set<LotteryNumber> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_PER_TICKET) {
            numbers.add(LotteryNumber.of(generateOne()));
        }
        validate(numbers);
        return numbers;
    }

    private static int generateOne() {
        int randomNumber = random.nextInt(RANDOM_MAX) + 1;
        if (randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        return randomNumber;
    }

    private void validate(Set<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET || numbers.stream().distinct().count() != NUMBER_PER_TICKET) {
            throw new RuntimeException("잘못된 로또 번호 목록입니다.");
        }
    }

}
