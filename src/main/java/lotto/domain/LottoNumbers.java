package lotto.domain;

import java.util.*;

public class LottoNumbers {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private Set<Integer> numbers;

    public LottoNumbers() {
        this.numbers = initLottoNumbers();
    }

    public LottoNumbers(final Set<Integer> numbers) {
        this.numbers = numbers;
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

    public boolean isRight(int winningNumber) {
        return numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
