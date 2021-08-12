package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {


    private final Random random = new Random();

    public static int LOTTO_MIN_NUMBER = 1;
    public static int LOTTO_MAX_NUMBER = 45;


    @Override
    public List<Integer> generate() {

        List<Integer> numbers = new ArrayList<>();

        IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER + 1).forEach(numbers::add);

        return convertLotto(numbers);
    }

    private List<Integer> convertLotto(List<Integer> numbers) {

        Collections.shuffle(numbers);

        numbers = numbers.subList(0, 6);

        Collections.sort(numbers);

        return numbers;
    }
}
