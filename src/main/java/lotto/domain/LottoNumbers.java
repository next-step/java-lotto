package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_TEXT_DELIMITER = ", ";
    private static final String INVALID_LOTTO_NUMBER_COUNT = "번호가 부족합니다. 입력된 번호 수 : %d";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String BLANK_LOTTO_NUMBERS = "로또 번호는 비어있을수 없습니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbers) {
        this(toLottoNumbers(lottoNumbers));
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static List<IntNumber> toListWinningNumberText(String lottoNumbers) {
        List<IntNumber> lottoNumberTexts = Arrays.stream(lottoNumbers.trim().split(LOTTO_NUMBERS_TEXT_DELIMITER))
                .map(IntNumber::new)
                .collect(Collectors.toList());
        validate(lottoNumberTexts);
        return lottoNumberTexts;
    }

    private static List<LottoNumber> toLottoNumbers(String lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isBlank()) {
            throw new IllegalArgumentException(BLANK_LOTTO_NUMBERS);
        }

        return toListWinningNumberText(lottoNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void validate(List<IntNumber> lottoNumberTexts) {
        if (lottoNumberTexts.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBER_COUNT, lottoNumberTexts.size()));
        }
    }

    public int matchCount(LottoNumbers otherLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(otherLottoNumbers::isContain)
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isEmpty() {
        return lottoNumbers.isEmpty();
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
        return lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(LOTTO_NUMBERS_TEXT_DELIMITER));
    }
}
