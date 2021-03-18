package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoGame {
    private List<Integer> numbers;

    public LottoGame(LottoNumber lottoNumber) {
        this(lottoNumber.numbers());
    }

    public LottoGame(List<Integer> givenLottoNumbers) {
        this.numbers = givenLottoNumbers;
        Collections.sort(this.numbers);
    }

    public int winningNumberCount(LottoGame winningLottoGame) {
        return winningNumberCount(winningLottoGame.numbers);
    }

    public int winningNumberCount(List<Integer> winningNumbers) {
        long winningNumberCount = winningNumbers.stream()
                .filter(winningNumber -> numbers.contains(winningNumber))
                .count();
        return (int) winningNumberCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
