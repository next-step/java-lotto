package lotto;

import java.util.List;

public class LottoGame {

    private final LottoNumbers numbers;
    private final LottoGamState state;

    public LottoGame(List<Integer> numbers) {
        this(numbers, LottoGamState.RANDOM);
    }

    public LottoGame(List<Integer> numbers, LottoGamState state) {
        this.numbers = new LottoNumbers(numbers);
        this.state = state;
    }

    public int countMatches(List<Integer> winningNumbers) {
        return numbers.countMatches(winningNumbers);
    }

    public boolean isManual() {
        return state == LottoGamState.MANUAL;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.hasBonusNumber(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
