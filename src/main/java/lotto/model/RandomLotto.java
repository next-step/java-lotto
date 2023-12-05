package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

    private static final List<Integer> numbers = new ArrayList<>();
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    static {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            numbers.add(i);
        }
    }

    private static List<Integer> shuffleLottoNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> cuttingLottoNumbers(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static List<Integer> pickLotto() {
        return cuttingLottoNumbers(shuffleLottoNumbers(numbers));
    }
}
