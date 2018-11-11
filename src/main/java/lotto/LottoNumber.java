package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private List<Integer> numbers = new ArrayList<>();

    public LottoNumber() {
    }

    public LottoNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
