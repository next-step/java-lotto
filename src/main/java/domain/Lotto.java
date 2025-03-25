package domain;


import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public int matchCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
