package step2.domain;

import java.util.*;

public class LottoNumberGenerator {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;
    private static final int ZERO = 0;

    public static List<List<Integer>> lottoNumbers(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(sortedLottoNumbers());
        }

        return result;
    }

    private static List<Integer> sortedLottoNumbers() {
        List<Integer> lottoNumbers = lottoNumbers();
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> lottoNumbers() {
        List<Integer> numbers = numbers();
        Collections.shuffle(numbers);
        return numbers.subList(ZERO, LOTTO_MAX_COUNT);
    }

    private static List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

}
