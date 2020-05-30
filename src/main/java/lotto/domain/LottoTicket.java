package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String DELIMITER_PATTERN = ", ";

    private final List<LottoNumber> lottoNumbers;
    private final CreationType creationType;

    private LottoTicket(List<LottoNumber> lottoNumbers, CreationType creationType) {
        validateLottoNumbers(lottoNumbers);
        validateCreationType(creationType);

        this.lottoNumbers = lottoNumbers;
        this.creationType = creationType;
    }

    public static LottoTicket newAutoLottoTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers, CreationType.AUTO);
    }

    public static LottoTicket newManualLottoTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers, CreationType.MANUAL);
    }

    public static LottoTicket newWinLottoTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers, CreationType.WIN);
    }

    private static void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
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

    public static List<LottoNumber> createNonDuplicateNumbers() {
        return NumbersFactory.createNonDuplicateNumbers(LOTTO_NUMBERS_COUNT);
    }

    public static List<LottoNumber> createNonDuplicateNumbers(String manualNumbers) {
        List<LottoNumber> lottoNumbers = NumbersFactory.createManualNumbers(manualNumbers);

        validateLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public LottoTicket clone() {
        return new LottoTicket(this.lottoNumbers, this.creationType);
    }

    public int getMatchCount(LottoTicket lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto::isMatchNumber)
                .count();
    }

    public boolean isMatchNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public boolean equalsCreationType(CreationType creationType) {
        return this.creationType.equals(creationType);
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
