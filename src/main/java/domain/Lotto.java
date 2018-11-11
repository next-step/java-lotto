package domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;
    public static final int PRICE = 1000;

    public Lotto() {
        numbers = new LottoNumbers().getValue();
    }

    public Lotto(String values) {
        numbers = new LottoNumbers(values).getValue();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
