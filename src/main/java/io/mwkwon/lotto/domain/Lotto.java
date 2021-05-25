package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final String DELIMITER = ",";
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "서로 다른 로또번호 6개가 아닙니다.";
    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "숫자 ','만 입력 가능합니다.";
    private static final String REGEX = "[^0-9, ]";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        checkDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public Lotto(final String strLottoNumbers) {
        checkValidNumberAndDelimiter(strLottoNumbers);
        List<LottoNumber> lottoNumbers = createLottoNumbers(strLottoNumbers);
        checkDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public static Lotto create(final String strLottoNumbers) {
        return new Lotto(strLottoNumbers);
    }

    public Set<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void checkValidNumberAndDelimiter(String strLottoNumbers) {
        Matcher matcher = Pattern.compile(REGEX).matcher(strLottoNumbers);
        if (matcher.find()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private List<LottoNumber> createLottoNumbers(String strLottoNumbers) {
        String[] split = strLottoNumbers.split(DELIMITER);
        return Stream.of(split)
                .map(strNumber -> new LottoNumber(Integer.parseInt(strNumber.trim())))
                .collect(Collectors.toList());
    }

    private void checkDuplicateLottoNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() < LottoConstants.LOTTO_BOUND) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
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
