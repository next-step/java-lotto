package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "서로 다른 로또번호 6개가 아닙니다.";

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
        checkDuplicateLottoNumber(this.lottoNumbers);
    }

    public static Lotto create(final List<LottoNumber> strLottoNumbers) {
        return new Lotto(strLottoNumbers);
    }

    public Set<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void checkDuplicateLottoNumber(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < LottoConstants.LOTTO_BOUND) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public long calcMatchLottoNumberCount(Lotto winningLotto) {
        return lottoNumbers
                .stream()
                .filter(lottoNumber -> winningLotto.isContains(lottoNumber))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
