package lotto.step3.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int LOTTO_BONUS_COUNT = 5;

    private final List<LottoNumber> numbers;

    public Lotto() {
        this.numbers = LottoGenerator.createLotto();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = LottoGenerator.createWinningNumbers(numbers);
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return countOfMatch(winningNumbers) == count;
    }

    public boolean isSecondPrizeWinner(Lotto winningNumbers, LottoNumber bonusBall) {
        return countOfMatch(winningNumbers) == LOTTO_BONUS_COUNT && hasBonusBall(bonusBall);
    }

    public int calculatePrizeMoney(Lotto winningNumbers, LottoNumber bonusBall) {
        return Rank.valueOf(countOfMatch(winningNumbers),
                isSecondPrizeWinner(winningNumbers, bonusBall)).getPrizeMoney();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private int countOfMatch(Lotto winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean hasBonusBall(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

}
