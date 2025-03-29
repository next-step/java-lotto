package domain;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public int matchCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::containsNumbers)
                .count();
    }

    public boolean matchBonusNumber(WinningNumber winningNumber) {
        return numbers.stream()
                .anyMatch(winningNumber::matchBonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(this.numbers);
    }
}
