package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static Lotto.LotterNumbers.LOTTO_COUNT;
import static Lotto.Money.MONEY_DIVIDE_REMAINDER_ZERO;

public class RandomNumberGenerator implements NumberGenerator {

    public static int LOTTO_MIN_NUMBER = 1;
    public static int LOTTO_MAX_NUMBER = 45;
    public static List<Integer> numbers = new ArrayList<>();


    @Override
    public List<Integer> generate() {

        IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1).forEach(numbers::add);

        return Collections.unmodifiableList(convertLotto(numbers));
    }

    private List<Integer> convertLotto(List<Integer> numbers) {

        Collections.shuffle(numbers);

        numbers = numbers.subList(MONEY_DIVIDE_REMAINDER_ZERO, 6);

        Collections.sort(numbers);

        return (numbers.stream().distinct().count() == LOTTO_COUNT) ? numbers : generate();
    }
}
