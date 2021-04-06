package lotto.domain;

import java.util.Objects;

public class LottoGame {
    public static final int NUMBER_BOUND = 6;

    private final Numbers numbers;

    public LottoGame(Numbers numbers) {
        this.numbers = numbers;
    }

    public HitResult match(WinNumbers winNumbers) {
        return new HitResult(numbers, winNumbers);
    }

    public Numbers getNumbers() {
        return numbers;
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
