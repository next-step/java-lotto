package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Lotto(List<Integer> numbers) {
    public static final int LOTTO_COUNT = 6;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    public Lotto {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        validate(numbers);
    }

    @Override
    public List<Integer> numbers() {
        return numbers;
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers()::contains)
                .count();
    }

    static void validate(List<Integer> list) {

        if (list.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (list.stream().distinct().count() != list.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        list.forEach(number -> {
            if (number < START_NUMBER || number > END_NUMBER) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        });
    }
}
