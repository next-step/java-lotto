package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int HAS_CONDITION = 1;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(LottoNumber... lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return getMatchCount(lottoNumber) == HAS_CONDITION;
    }

    public long getMatchCount(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .filter(number -> number.equals(lottoNumber))
                .count();
    }

    public int countMatchNumbers(LottoNumbers lottoNumbers) {
        List<LottoNumber> otherNumbers = lottoNumbers.getLottoNumbers();
        return (int) this.lottoNumbers.stream()
                .filter(otherNumbers::contains)
                .count();
    }

    public List<Integer> toIntNumbers() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::intValue)
                .boxed()
                .collect(toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoNumbersSizeException();
        }
    }

}
