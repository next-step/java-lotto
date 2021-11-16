package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        createRandomNumber();
    }

    public Lotto(List<Integer> numbers) {
        checkNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count() == count;
    }

    private void createRandomNumber() {
        int[] array = new int[LOTTO_NUMBER];
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            array[i] = i + 1;
        }
        while (numbers.size() != LOTTO_SIZE) {
            int randomIndex = new Random().nextInt(LOTTO_NUMBER - 1) + 1;
            addNotDuplicateNumbers(numbers, array, randomIndex);
        }
        Collections.shuffle(numbers);
    }

    private void addNotDuplicateNumbers(List<Integer> numbers, int[] array, int randomIndex) {
        if (!numbers.contains(array[randomIndex])) {
            numbers.add(array[randomIndex]);
        }
    }

    private void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력 해주세요!!");
        }
        numbers.forEach(n -> {
                    if (!(1 <= n && n <= 45)) {
                        throw new IllegalArgumentException("1~45 숫자를 입력해주세요!!");
                    }
                });
    }

}
