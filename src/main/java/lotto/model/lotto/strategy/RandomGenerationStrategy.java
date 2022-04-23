package lotto.model.lotto.strategy;

import lotto.model.lotto.LottoNumber;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomGenerationStrategy implements NumberGenerationStrategy {

    private static final int MAX_LOTTO_NUMBER_BOUND = 45;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private static final int LOTTO_MIN_NUMBER = 1;

    private static final Random RANDOM = new Random();

    @Override
    public Set<LottoNumber> generateLottoNumbers() {
        Set<Integer> numbers = generateRandomNumber();
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private Set<Integer> generateRandomNumber() {
        Set<Integer> numbers = new HashSet<>();

        while(numbers.size() < LOTTO_NUMBERS_SIZE) {
            int number = generateNumber();
            if (numbers.contains(number) || isInvalidLottoNumber(number)) {
                continue;
            }
            numbers.add(number);
        }

        return numbers;
    }

    private boolean isInvalidLottoNumber(int number) {
        return ((number > MAX_LOTTO_NUMBER_BOUND) || (number < LOTTO_MIN_NUMBER));
    }

    private int generateNumber() {
        return RANDOM.nextInt(MAX_LOTTO_NUMBER_BOUND);
    }

}
