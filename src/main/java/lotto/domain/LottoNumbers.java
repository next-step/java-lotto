package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private static final List<Integer> ALL_LOTTO_NUMBERS;

    static {
        ALL_LOTTO_NUMBERS = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            ALL_LOTTO_NUMBERS.add(i);
        }
    }

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static LottoNumbers generateLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(ALL_LOTTO_NUMBERS);
        Collections.shuffle(lottoNumbers);
        List<Integer> selectedNumbers = lottoNumbers.subList(0, LOTTO_COUNT);
        Collections.sort(selectedNumbers);
        return new LottoNumbers(selectedNumbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
