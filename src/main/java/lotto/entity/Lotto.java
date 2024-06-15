package lotto.entity;

import java.util.Set;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final String LOTTO_NUMBERS_ARE_6_NUMBER = "로또번호는 6개입니다.";
    public static final String LOTTO_NUMBERS_ARE_NUMBERS_1_TO_45 = "로또번호는 1~45의 숫자입니다.";

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_6_NUMBER);
        }

        numbers.forEach(integer -> {
            if (integer < MIN_LOTTO_NUMBER || integer > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_ARE_NUMBERS_1_TO_45);
            }
        });
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
