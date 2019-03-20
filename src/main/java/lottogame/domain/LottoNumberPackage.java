package lottogame.domain;

import lottogame.validator.InputValidatable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 로또 1게임
 */
public class LottoNumberPackage implements InputValidatable<List<Integer>> {

    public static final int LOTTO_GAME_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumberPackage(List<Integer> lottoNumbers) {
        if (isInvalid(lottoNumbers)) {
            throw new IllegalArgumentException();
        }

        numbers = getNumbers(lottoNumbers);
    }

    private List<LottoNumber> getNumbers(List<Integer> numbers) {
        return numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList());
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int getMatchedCount(LottoNumberPackage targetNumbers) {

        if( targetNumbers == null ||
            targetNumbers.getNumbers() == null ||
            targetNumbers.getNumbers().size() <= 0 ) {
            return 0;
        }

        return (int)targetNumbers.getNumbers()
                                 .stream()
                                 .filter(this::contains)
                                 .count();
    }

    public boolean contains(LottoNumber targetNumber) {
        return Optional.ofNullable(targetNumber)
                .filter(numbers::contains)
                .isPresent();
    }

    @Override
    public boolean isInvalid(List<Integer> lottoNumbers) {
        return lottoNumbers == null || lottoNumbers.size() != LOTTO_GAME_SIZE;
    }

    @Override
    public String getInvalidMessage() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberPackage that = (LottoNumberPackage) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}