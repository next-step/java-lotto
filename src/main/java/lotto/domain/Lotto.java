package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.List;

public class Lotto {

    private boolean isAutomatic;
    private List<LottoNo> numbers;

    private Lotto(List<LottoNo> numbers, boolean isAutomatic) {
        this.numbers = numbers;
        this.isAutomatic = isAutomatic;
    }

    public static Lotto create() {
        return new Lotto(LottoNumberGenerator.generate(), true);
    }

    public static Lotto create(List<LottoNo> numbers) {
        return new Lotto(numbers, true);
    }

    public static Lotto create(List<LottoNo> numbers, boolean isAutomatic) {
        return new Lotto(numbers, isAutomatic);
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

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public boolean isManual() {
        return !isAutomatic;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
