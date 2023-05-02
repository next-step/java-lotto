package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoGenerator.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoGenerator.MIN_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d~%d 사이의 숫자여야 합니다", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public boolean isMatchesWinningNumber(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> number == winningNumber);
    }

    public int findLottoNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }
}


