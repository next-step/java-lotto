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

    public int winningNumberCount(List<Integer> winningNumbers) {
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        return winningNumberCount(winningNumber);
    }

    public int winningNumberCount(WinningNumber winningNumber) {
        return winningNumber.matchCount(this);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
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
