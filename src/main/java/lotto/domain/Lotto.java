package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if(numbers == null){
            throw new IllegalArgumentException();
        }
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateNumbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateIfDuplication(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfDuplication(List<LottoNumber> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != count) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(new LottoNumber(number));
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
