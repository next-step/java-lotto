package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_TEXT_DELIMITER = ", ";
    private static final String INVALID_LOTTO_NUMBER_COUNT = "번호가 부족합니다. 입력된 번호 수 : %d";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String BLANK_LOTTO_NUMBERS = "로또 번호는 비어있을수 없습니다.";

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbers) {
        this(toLottoNumbers(lottoNumbers));
    }

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static List<String> toListWinningNumberText(String lottoNumbers) {
        List<String> lottoNumberTexts = Arrays.stream(lottoNumbers.trim().split(LOTTO_NUMBERS_TEXT_DELIMITER))
                .collect(Collectors.toList());
        validate(lottoNumberTexts);
        return lottoNumberTexts;
    }

    private static Set<LottoNumber> toLottoNumbers(String lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isBlank()) {
            throw new IllegalArgumentException(BLANK_LOTTO_NUMBERS);
        }

        return toListWinningNumberText(lottoNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static void validate(List<String> lottoNumberTexts) {
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
