package lotto.domain;

import lotto.utils.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final String LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE = "로또 번호는 6자리 수여야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(String numbers) {
        return of(StringUtils.toIntegerList(numbers));
    }

    public static LottoNumbers of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public Prize match(LottoNumbers winningNumbers) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return Prize.findByMatchCount(matchCount);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_ERROR_MESSAGE);
        }

        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
