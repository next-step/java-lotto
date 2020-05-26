package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER_PATTERN = ", ";

    private final List<Integer> lottoNumbers;
    private final CreationType creationType;

    private LottoNumber(List<Integer> lottoNumbers, CreationType creationType) {
        validateLottoNumbers(lottoNumbers);
        validateCreationType(creationType);

        this.lottoNumbers = lottoNumbers;
        this.creationType = creationType;
    }

    public static LottoNumber newInstance(List<Integer> lottoNumbers) {
        return new LottoNumber(lottoNumbers, CreationType.NONE);
    }

    public static LottoNumber newInstance(List<Integer> lottoNumbers, CreationType creationType) {
        return new LottoNumber(lottoNumbers, creationType);
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

    private void validateCreationType(CreationType creationType) {
        if (creationType == null) {
            throw new IllegalArgumentException("생성 유형이 존재하지 않습니다.");
        }
    }

    public static List<Integer> createNonDuplicateNumbers() {
        return NumbersFactory.createNonDuplicateNumbers(LOTTO_NUMBERS_COUNT);
    }

    public static List<Integer> createNonDuplicateNumbers(String manualNumbers) {
        List<Integer> lottoNumbers = NumbersFactory.createManualNumbers(manualNumbers);

        validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public LottoNumber clone() {
        return new LottoNumber(this.lottoNumbers, this.creationType);
    }

    public int getMatchCount(LottoNumber lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto::isMatchNumber)
                .count();
    }

    public CreationType getCreationType() {
        return this.creationType;
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
