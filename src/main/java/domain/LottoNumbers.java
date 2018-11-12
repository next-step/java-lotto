package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int match(WinningNumber winningNumber) {
        return (int) numbers.stream()
            .filter(winningNumber::isContain)
            .count();
    }

    public boolean matchBonus(WinningNumber winningNumber) {
        return numbers.stream()
            .anyMatch(winningNumber::isBonusMatched);
    }

    @Override
    public String toString() {
        return String.join(
            ", ",
            numbers.stream().map(LottoNumber::toString).collect(Collectors.toList()));
    }
}
