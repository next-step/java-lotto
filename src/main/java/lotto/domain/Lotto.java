package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_ZERO = 0;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String ERROR_MESSAGE = "로또 숫자는 중복될 수 없습니다.";
    private static final String SPACE_DELIMITER = " ";
    private static final String BLANK_DELIMITER = "";
    private static final String COMMA = ",";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumber) {
        List<LottoNumber> lottoFullNumberLengthSix = lottoNumber.subList(NUMBER_ZERO,
            LOTTO_NUMBER_SIZE);
        Collections.sort(lottoFullNumberLengthSix);
        validateNonDuplication(lottoFullNumberLengthSix);
        this.lottoNumbers = new ArrayList<>(lottoFullNumberLengthSix);
    }

    public Lotto(final String lottoNumber) {
        this.lottoNumbers = Arrays.stream(
                lottoNumber
                    .replace(SPACE_DELIMITER, BLANK_DELIMITER)
                    .split(COMMA))
            .map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validateNonDuplication(final List<LottoNumber> lottoFullNumberLengthSix) {
        Set<LottoNumber> LottoNumberSet = new HashSet<>(lottoFullNumberLengthSix);
        if (LottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }


    public boolean isContainsLottoNumber(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean isContainsConvertInt(final LottoNumber lottoNumber) {
        return this.getLottoNumbers().contains(lottoNumber.getValue());
    }
    
    public List<Integer> getLottoNumbers() {
        return lottoNumbers
            .stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toList());
    }

    public long countMatch(final Lotto lottoNumber) {
        return this.lottoNumbers.stream()
            .filter(lottoNumber::isContainsLottoNumber)
            .count();
    }

}
