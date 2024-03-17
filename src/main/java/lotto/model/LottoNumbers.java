package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final int START_INCLUSIVE = 0;
    private static final int END_EXCLUSIVE = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }

    public static List<LottoNumber> of(Integer... numbers) {
        List<Integer> uniqueNumbers = removeDuplicatedNumber(numbers);

        List<LottoNumber> result = new ArrayList<>();
        for (int number : uniqueNumbers) {
            assertInvalidNumber(number);

            result.add(LOTTO_NUMBERS.get(number - 1));
        }

        return result;
    }

    private static List<Integer> removeDuplicatedNumber(Integer[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .collect(toList());
    }

    private static void assertInvalidNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new InvalidLottoException("로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자만 선택 가능합니다");
        }
    }

    public static List<LottoNumber> selectRandomLottoNumbers() {
        List<LottoNumber> shuffled = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(shuffled);
        return shuffled.subList(START_INCLUSIVE, END_EXCLUSIVE);
    }

}
