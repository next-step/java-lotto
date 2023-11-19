package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            numbers.add(number);
        }
        return shuffleAndSort(numbers);
    }

    public static List<Integer> generate(List<Integer> lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber);
        }
        return shuffleAndSort(numbers);
    }

    private static List<Integer> shuffleAndSort(List<Integer> numbers) {
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }

}
