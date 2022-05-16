package lotto.domain;

import java.util.*;
import java.util.regex.Pattern;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String WRONG_NUMBER_SIZE_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String WRONG_INPUT_MESSAGE = "숫자, 공백 및 문자 , 만 사용 가능합니다.";
    private static final String DUPLICATED_NUMBER_ERROR = "중복된 번호가 있습니다.";
    private static final String DELIMITER = ",";
    private static final String SPACE_TARGET = "\\s+";
    private static final String OPERATOR_PATTERN_REGEX = "^[\\d,\\s]*$";
    private static final Pattern operatorPattern = Pattern.compile(OPERATOR_PATTERN_REGEX);
    private static final String REPLACEMENT_BLANK = "";

    private final List<LottoNumber> lottoNumbers;

    public Lotto(String lottoNumbers) {
        this(toLottoNumberList(lottoNumbers));
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static List<LottoNumber> toLottoNumberList(String lottoNumbers) {
        validateInputString(lottoNumbers);
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (String lottoNumber : split(lottoNumbers)) {
            lottoNumberList.add(LottoNumber.valueOf(lottoNumber));
        }
        return lottoNumberList;
    }

    private static void validateInputString(String lottoNumber) {
        if (!isOperatorMatchers(lottoNumber)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    private static boolean isOperatorMatchers(String lottoNumber) {
        return operatorPattern.matcher(replace(lottoNumber)).matches();
    }

    private static String[] split(String lottoNumber) {
        return replace(lottoNumber).split(DELIMITER);
    }

    private static String replace(String lottoNumber) {
        return lottoNumber.replaceAll(SPACE_TARGET, REPLACEMENT_BLANK);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_NUMBER_SIZE_MESSAGE);
        }
        HashSet<LottoNumber> distinctLottoNumbers = new HashSet<>(lottoNumbers);
        if (distinctLottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR);
        }
    }

    private void sort(List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
    }

    public boolean isSize(int size) {
        return size == LOTTO_NUMBER_COUNT;
    }

    public Rank getRank(WinningLotto winningLottoNumber) {
        boolean bonus = winningLottoNumber.hasBonus(this);
        int matchCount = winningLottoNumber.matchCount(this);
        return Rank.valueOf(matchCount, bonus);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) winningLotto.lottoNumbers
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
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
