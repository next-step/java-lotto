package step2.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int ALLOWED_LOTTO_NUMBER_COUNT = 6;

    private final LottoType lottoType;
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers, LottoType lottoType) {
        validateArguments(numbers, lottoType);

        this.numbers = numbers;
        this.lottoType = lottoType;
    }

    private void validateArguments(List<LottoNumber> numbers, LottoType lottoType) {
        if (isInvalidCount(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개만 입력 가능합니다.");
        }

        if (isDuplicateExist(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        if (lottoType == null) {
            throw new IllegalArgumentException("로또 타입을 입력해주세요.");
        }
    }

    private boolean isInvalidCount(List<LottoNumber> numbers) {
        return numbers == null || numbers.size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    private boolean isDuplicateExist(List<LottoNumber> numbers) {
        return new HashSet<>(numbers).size() != ALLOWED_LOTTO_NUMBER_COUNT;
    }

    public static Lotto createAuto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers, LottoType.AUTO);
    }

    public static Lotto createManual(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers, LottoType.MANUAL);
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        return matchingResult(winningNumbers).size();
    }

    private List<LottoNumber> matchingResult(WinningNumbers winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::containsNumber)
                .collect(Collectors.toList());
    }

    public boolean containsNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public boolean isAuto() {
        return this.lottoType == LottoType.AUTO;
    }

    public boolean isManual() {
        return this.lottoType == LottoType.MANUAL;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
