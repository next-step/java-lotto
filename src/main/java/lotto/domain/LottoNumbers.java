package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toList;

interface Numbers {
    List<Integer> of();
}

public class LottoNumbers implements Numbers {
    public static final int LOTTO_NUMBER_BOUNDARY = 45;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_SIZE = 6;

    Random random = new Random();

    @Override
    public List<Integer> of() {
        List<Integer> numbers = generate();
        shuffle(numbers);
        return numbers;
    }

    private List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != LOTTO_NUMBER_SIZE) {
            numbers.add(generateRandomNumber());
        }
        return numbers.stream()
                .collect(toList());
    }

    private int generateRandomNumber() {
        return random.nextInt(LOTTO_NUMBER_BOUNDARY) + MINIMUM_LOTTO_NUMBER;
    }
}
