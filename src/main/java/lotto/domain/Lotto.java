package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_VALID_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = createLottoNumbers();
        this.numbers.sort(Integer::compareTo);
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private static List<Integer> createLottoNumbers() {
        List<Integer> lottos = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            lottos.add(i);
        }
        Collections.shuffle(lottos);

        return lottos.subList(0, LOTTO_VALID_SIZE);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_VALID_SIZE) {
            throw new IllegalArgumentException("lotto number 개수는 6개입니다.");
        }

        for (Integer number : numbers) {
            checkNumberValue(number);
        }
    }

    private void checkNumberValue(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("lotto number는 1과 45사이의 숫자입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Integer number) {
        return this.numbers.stream()
                .anyMatch(n -> n.equals(number));
    }
}
