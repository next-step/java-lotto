package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:53
 */
public class LottoNumberStrategy implements RandomGenerateStrategy{

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final Random random = new Random();

    @Override
    public List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            numbers.add(getRandomNumberRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM));
        }
        return numbers;
    }

    private static int getRandomNumberRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return random.nextInt((max - min) + 1) + min;
    }
}
