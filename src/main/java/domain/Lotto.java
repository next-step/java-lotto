package domain;


import java.util.List;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
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
