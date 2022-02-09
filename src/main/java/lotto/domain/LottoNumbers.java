package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final static int NUMBER_ZERO = 0;
    private final static int LOTTO_NUMBER_SIZE = 6;
    private final static String ERROR_MESSAGE = "로또 숫자는 중복될 수 없습니다.";
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        List<LottoNumber> lottoNumbersLengthSix = lottoNumbers.subList(NUMBER_ZERO,
            LOTTO_NUMBER_SIZE);
        Collections.sort(lottoNumbersLengthSix);
        validateNonDuplication(lottoNumbersLengthSix);
        this.lottoNumbers = new ArrayList<>(lottoNumbersLengthSix);
    }

    private void validateNonDuplication(final List<LottoNumber> lottoNumbersLengthSix) {
        Set<LottoNumber> LottoNumbersSet = new HashSet<>(lottoNumbersLengthSix);
        if (LottoNumbersSet.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers
            .stream()
            .map(LottoNumber::value)
            .collect(Collectors.toList());
    }

    public long countMatch(final LottoNumbers lottoNumbers){
        return this.lottoNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }


}
