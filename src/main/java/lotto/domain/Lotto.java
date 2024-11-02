package lotto.domain;

import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        validateWinningNumbersCount(numbers);

        numbers.forEach(this::validateNumber);
    }

    private void validateNumber(int lottoNumber) {
        if (LOTTO_MIN_NUMBER > lottoNumber || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 정수여야 합니다.");
        }
    }

    private void validateWinningNumbersCount(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 중복되지 않는 " + LOTTO_SIZE + "개의 숫자여야 합니다.");
        }
    }


    public LottoRank getLottoRank(Lotto winningLotto) {

        long matchCount = this.numbers.stream()
                .filter(winningLotto.getLottoNumbers()::contains)
                .count();

        return LottoRank.getLottoRank((int) matchCount);
    }

    public Set<Integer> getLottoNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
