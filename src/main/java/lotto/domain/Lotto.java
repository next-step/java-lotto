package lotto.domain;

import lotto.domain.type.Rank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public abstract class Lotto {
    public static final int PRICE = 1000;

    public static final int LOTTO_SIZE = 6;
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 6개 이어야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }

        if (isDuplicate(lottoNumbers)) {
            throw new IllegalArgumentException("로또에 중복 숫자가 존재합니다.");
        }
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumbers) {
        return new HashSet<>(lottoNumbers).size() != LOTTO_SIZE;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }



    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public abstract boolean isAuto();
}
