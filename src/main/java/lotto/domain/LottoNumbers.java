package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_TEXT_DELIMITER = ", ";

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
        return Arrays.stream(lottoNumbers.trim().split(LOTTO_NUMBERS_TEXT_DELIMITER))
                .collect(Collectors.toList());
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
    public String toString() {
        return lottoNumbers.stream().map(Object::toString).collect(Collectors.joining(LOTTO_NUMBERS_TEXT_DELIMITER));
    }
}
