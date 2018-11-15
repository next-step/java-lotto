package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.List;

public class Lotto {

    private List<LottoNo> numbers;

    private Lotto(List<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto(LottoNumberGenerator.generate());
    }

    public static Lotto create(List<LottoNo> numbers) {
        return new Lotto(numbers);
    }

    public boolean hasMatches(List<LottoNo> winningNumbers, int count) {
        return count == this.numberOfMatches(winningNumbers);
    }

    public int numberOfMatches(List<LottoNo> winningNumbers) {
        return Math.toIntExact(winningNumbers.stream()
                .filter(this::contains)
                .count());
    }

    private boolean contains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
