package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_TEXT_DELIMITER = ", ";
    private static final String INVALID_LOTTO_NUMBER_COUNT_= "번호가 부족합니다.";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(String lottoNumbers) {
        this.lottoNumbers = toListWinningNumberText(lottoNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    private static List<String> toListWinningNumberText(String lottoNumbers) {
        List<String> lottoNumberTexts = Arrays.stream(lottoNumbers.trim().split(LOTTO_NUMBERS_TEXT_DELIMITER))
                .collect(Collectors.toList());
        validate(lottoNumberTexts);
        return lottoNumberTexts;
    }

    private static void validate(List<String> lottoNumberTexts) {
        if (lottoNumberTexts.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT_);
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
