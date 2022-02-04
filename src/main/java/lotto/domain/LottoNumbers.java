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
    private final List<LottoNumber> lottoFullNumber;

    public LottoNumbers(final List<LottoNumber> lottoFullNumber) {
        List<LottoNumber> lottoFullNumberLengthSix = lottoFullNumber.subList(NUMBER_ZERO,
            LOTTO_NUMBER_SIZE);
        Collections.sort(lottoFullNumberLengthSix);
        validateNonDuplication(lottoFullNumberLengthSix);
        this.lottoFullNumber = new ArrayList<>(lottoFullNumberLengthSix);
    }

    private void validateNonDuplication(final List<LottoNumber> lottoFullNumberLengthSix) {
        Set<LottoNumber> LottoNumberSet = new HashSet<>(lottoFullNumberLengthSix);
        if (LottoNumberSet.size() != LOTTO_NUMBER_SIZE){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public List<Integer> getLottoFullNumber() {
        return lottoFullNumber
            .stream()
            .map(LottoNumber::value)
            .collect(Collectors.toList());
    }

    public long countMatch(final LottoNumbers lottoFullNumber){
        return this.lottoFullNumber.stream()
            .filter(lottoFullNumber::contains)
            .count();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoFullNumber.contains(lottoNumber);
    }


}
