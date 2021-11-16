package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Number> numbers = new ArrayList<>();

    private LottoNumbers() {
        while (numbers.size() < LOTTO_NUMBERS_SIZE) {
            numbers.add(Number.create());
        }
    }

    public static LottoNumbers create() {
        return new LottoNumbers();
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
