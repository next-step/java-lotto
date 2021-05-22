package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    public static final int FROM_INDEX = 0;
    public static final int LOTTO_BOUND = 6;
    public static final String DELIMITER = ",";
    public static final String DUPLICATE_EXCEPTION_MESSAGE = "서로 다른 로또번호 6개가 아닙니다.";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "숫자 ','만 입력 가능합니다.";
    public static final String REGEX = "[^0-9,]";

    private final Set<LottoNumber> lottoNumbers;

    static {
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        checkDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public Lotto(String strLottoNumbers) {
        checkValidNumberAndDelimiter(strLottoNumbers);
        List<LottoNumber> lottoNumbers = createLottoNumbers(strLottoNumbers);
        checkDuplicateLottoNumber(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
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
                .map(strNumber -> new LottoNumber(Integer.parseInt(strNumber)))
                .collect(Collectors.toList());
    }

    private void checkDuplicateLottoNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() < LOTTO_BOUND) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public static Lotto createAutoLotto() {
        List<LottoNumber> autoLottoNumbers = createAutoLottoNumbers();
        return new Lotto(autoLottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public Rank calcLottoRank(Lotto winningLotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : winningLotto.lottoNumbers) {
            matchCount = calcMatchCount(matchCount, lottoNumber);
        }
        return Rank.getRankByMatchCount(matchCount);
    }

    private int calcMatchCount(int matchCount, LottoNumber lottoNumber) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            matchCount++;
        }
        return matchCount;
    }

    private static List<LottoNumber> createAutoLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(FROM_INDEX, LOTTO_BOUND);
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
