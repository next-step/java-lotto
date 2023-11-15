package lotto.domain;

import java.util.*;

public class LottoNumbers {
    public static final String INVALID_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_MSG = "로또 번호는 1이상 45이하 여야 합니다.";
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private Set<Integer> numbers;

    public LottoNumbers() {
        this.numbers = initLottoNumbers();
    }

    public LottoNumbers(final Set<Integer> numbers) {
        validationCheck(numbers);
        this.numbers = numbers;
    }

    private void validationCheck(final Set<Integer> numbers) {
        lottoCountCheck(numbers);

        for (Integer number : numbers) {
            lottoNumberCheck(number);
        }
    }

    private void lottoCountCheck(final Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT);
        }
    }

    private void lottoNumberCheck(final Integer number) {
        if (MIN_LOTTO_NUMBER > number && number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_MSG);
        }
    }

    private Set<Integer> initLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> tempNumber = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            tempNumber.add(numbers.get(i));
        }

        Collections.sort(tempNumber);

        return new LinkedHashSet<>(tempNumber);
    }

    public boolean contains(int winningNumber) {
        return numbers.contains(winningNumber);
    }

    public int getRightNumber(final LottoNumbers winningNumbers) {
        int rightNumber = 0;
        for (int number : winningNumbers.numbers) {
            rightNumber = plusRightNumber(rightNumber, number);
        }

        return rightNumber;
    }

    private int plusRightNumber(int rightNumber, final int number) {
        if (contains(number)) {
            rightNumber++;
        }
        return rightNumber;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
