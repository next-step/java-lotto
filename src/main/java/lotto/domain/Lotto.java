package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final static int NUMBER_ZERO = 0;

    private final static int LOTTO_NUMBER_SIZE = 6;

    private static final String ERROR_MESSAGE = "로또 숫자는 중복될 수 없습니다.";
    private static final String SPACE_DELIMITER = " ";
    private static final String BLANK_DELIMITER = "";
    private static final String COMMA = ",";

    private final List<LottoNumber> lottoNumber;

    public Lotto(List<LottoNumber> lottoNumber) {
        List<LottoNumber> lottoFullNumberLengthSix = lottoNumber.subList(NUMBER_ZERO,
            LOTTO_NUMBER_SIZE);
        Collections.sort(lottoFullNumberLengthSix);
        validateNonDuplication(lottoFullNumberLengthSix);
        this.lottoNumber = new ArrayList<>(lottoFullNumberLengthSix);
    }

    public Lotto(String lottoNumber) {
        this.lottoNumber =
            Arrays.stream(
                    lottoNumber
                        .replace(SPACE_DELIMITER, BLANK_DELIMITER)
                        .split(COMMA))
                .mapToInt(Integer::new)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNonDuplication(List<LottoNumber> lottoFullNumberLengthSix) {
        Set<LottoNumber> LottoNumberSet = new HashSet<>(lottoFullNumberLengthSix);
        if (LottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }


    public boolean get(LottoNumber lottoNumber) {
        return this.lottoNumber.contains(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber
            .stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toList());
    }

    public long countMatch(Lotto lottoNumber) {
        return this.lottoNumber.stream()
            .filter(lottoNumber::get)
            .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.getLottoNumber().contains(lottoNumber.getValue());
    }
}
