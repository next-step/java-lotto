package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> numbers;

    public LottoNumbers(int... numbers) {
        isPossibleLottoNumbers(numbers);
        this.numbers = IntStream.of(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    private LottoNumbers(int minLottoNumber, int maxLottoNumber) {
        List<Integer> shuffledNumbers = IntStream.rangeClosed(minLottoNumber, maxLottoNumber)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(shuffledNumbers);
        this.numbers = shuffledNumbers.subList(0, 6);
        Collections.sort(this.numbers);
    }

    public LottoNumbers() {
        this(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private static void isPossibleLottoNumbers(int[] numbers) {
        duplicateCheck(numbers);
        lengthCheck(numbers);
        for (int number : numbers) {
            isValidNumber(number);
        }
    }

    private static void duplicateCheck(int[] numbers) {
        if (Arrays.stream(numbers).distinct().count() < numbers.length) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void lengthCheck(int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private static void isValidNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }
}
