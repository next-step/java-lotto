package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateNumbers(numbers);
    }

    private List<LottoNumber> validateNumbers(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "numbers must not be null");

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Lotto numbers must contain exactly 6 numbers.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must be unique.");
        }

        return lottoNumbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

}
