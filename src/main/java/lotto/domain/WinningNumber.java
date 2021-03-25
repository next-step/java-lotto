package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumber {
    private LottoGame winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this(new LottoGame(numbers), bonusNumber);
    }

    public WinningNumber(LottoGame winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        if (bonusNumber < LottoRule.min() || bonusNumber > LottoRule.max()) {
            throw new IllegalArgumentException();
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(LottoGame game) {
        return Rank.valueOf(countOfMatch(game), matchBonus(game));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return bonusNumber == that.bonusNumber && Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber, bonusNumber);
    }

    private boolean matchBonus(LottoGame lottoGame) {
        return lottoGame.contains(bonusNumber);
    }

    private int countOfMatch(LottoGame lottoGame) {
        return winningNumber.countOfMatch(lottoGame);
    }
}
