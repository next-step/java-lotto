package lotto.domain;

import lotto.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER_PATTERN = ", ";

    private final List<Integer> lottoNumbers;

    private LottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers newInstance(List<Integer> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또 번호를 생성할 수 없습니다.");
        }

        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }

        if (new HashSet<>(lottoNumbers).size() < LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("중복된 번호를 포함할 수 없습니다.");
        }
    }

    public static List<Integer> createNonDuplicateNumbers() {
        return NumbersFactory.createNonDuplicateNumbers(LOTTO_NUMBERS_COUNT);
    }

    public static List<Integer> createNonDuplicateNumbers(String manualNumbers) {
        List<Integer> lottoNumbers = Arrays.stream(manualNumbers.split(DELIMITER_PATTERN))
                .map(StringUtils::toInt)
                .collect(Collectors.toList());

        validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public LottoNumbers clone() {
        return new LottoNumbers(this.lottoNumbers);
    }

    public int getMatchCount(LottoNumbers lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto::isMatchNumber)
                .count();
    }

    public boolean isMatchNumber(int number) {
        return this.lottoNumbers.contains(number);
    }

    private String getLottoNumbersToString() {
        return this.lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER_PATTERN));
    }

    @Override
    public String toString() {
        return PREFIX + getLottoNumbersToString() + SUFFIX;
    }
}
