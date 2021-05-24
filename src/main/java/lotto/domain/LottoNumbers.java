package lotto.domain;

import lotto.utils.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final String LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE = "로또 번호는 6자리 수여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(String numbers) {
        return of(StringUtils.toIntegerList(numbers));
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(toLottoNumberList(numbers));
    }

    protected static List<LottoNumber> toLottoNumberList(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

    public Prize match(WinningNumbers winningNumbers) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean hasBonusNumber = lottoNumbers.stream()
                .anyMatch(winningNumbers::isSameAsBonusNumber);

        return Prize.valueOf(matchCount, hasBonusNumber);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE);
        }

        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    protected boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
