package lotto.domain;

import java.util.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 23:36
 */
public class LottoGenerator implements LottoNumberStrategy {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Random random = new Random();

    @Override
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != LOTTO_NUMBER_SIZE) {
            numbers.add(getRandomNumberRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM));
        }

        return new ArrayList<>(numbers);
    }

    private static int getRandomNumberRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}
