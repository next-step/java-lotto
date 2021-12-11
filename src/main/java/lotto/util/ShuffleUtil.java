package lotto.util;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ShuffleUtil {

    public static List<Integer> shuffledNumbers(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    public static List<LottoNumber> shuffledLottoNumbers(int min, int max, int size) {
        List<Integer> numbers = sortedNumbers(shuffledNumbers(min, max), size);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }

    private static List<Integer> sortedNumbers(List<Integer> numbers, int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(numbers.get(i));
        }
        Collections.sort(result);
        return result;
    }

}
