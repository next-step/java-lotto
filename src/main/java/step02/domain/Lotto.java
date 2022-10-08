package step02.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_STRING_DELIMITER = ",";

    public static final List<LottoNumber> lottoAllNumbers =
        rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final List<LottoNumber> value = new ArrayList<>();

    public Lotto(List<LottoNumber> value) {
        validateLotto(value);
        this.value.addAll(value);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public static Lotto of(String numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(LOTTO_STRING_DELIMITER))
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public static Lotto create() {
        Collections.shuffle(lottoAllNumbers);
        List<LottoNumber> lottoNumbers = lottoAllNumbers.subList(0, LOTTO_NUMBERS_SIZE).stream()
            .sorted()
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getValue() {
        return Collections.unmodifiableList(value);
    }

    public LottoGrade getGradeByComparison(WinningLottoNumbers winningLottoNumbers) {
        Set<LottoNumber> lottoNumbersSet = new HashSet<>(value);

        List<LottoNumber> lottoNumbers = winningLottoNumbers.getLottoNumbers();
        int count = (int) lottoNumbers.stream()
            .filter(lottoNumbersSet::contains)
            .count();

        LottoNumber bonusNumber = winningLottoNumbers.getBonusNumber();
        boolean bonusMatch = lottoNumbersSet.contains(bonusNumber);
        return LottoGrade.from(count, bonusMatch);
    }

    private void validateLotto(List<LottoNumber> numbers) {
        validateSizeIsSix(numbers);
        validateIsSorted(numbers);
    }

    private void validateSizeIsSix(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개의 번호여야 합니다. | numbers: " + numbers);
        }
    }

    private void validateIsSorted(List<LottoNumber> numbers) {
        List<LottoNumber> sorted = numbers.stream().sorted().collect(Collectors.toList());
        if (!sorted.equals(numbers)) {
            throw new IllegalArgumentException("로또 번호는 정렬된 번호여야 합니다. | numbers: " + numbers);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return value != null ? value.equals(lotto.value) : lotto.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
