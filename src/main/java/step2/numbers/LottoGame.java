package step2.numbers;

import java.util.List;

public class LottoGame {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int NUMBER_COUNT = 6;
    private static final String JOINER = ", ";
    private List<Number> numbers;

    public LottoGame(List<Number> lottoNumbers) {this.numbers = lottoNumbers;}

    public String toString() {
        return numbers.stream()
                .map(Number :: toString)
                .reduce((o1, o2) -> o1 + JOINER + o2)
                .orElseThrow(IllegalArgumentException :: new);
    }

    public int matchWinningNumberCount(WinningLotto winningLotto) {
        return Math.toIntExact(numbers.stream().filter(winningLotto :: contains).count());
    }

    public boolean containsBonus(WinningLotto winningLotto) {
        return winningLotto.hasBonus(numbers);
    }
}
