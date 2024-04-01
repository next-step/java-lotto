package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonus;

    public Lotto(final Set<LottoNumber> numbers, final LottoNumber bonus) {
        validateNumbersHaveSpecifiedSize(numbers);
        validateBonusIsNotDuplicated(numbers, bonus);

        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validateNumbersHaveSpecifiedSize(final Set<LottoNumber> numbers) {
        if (numbers.size() < LOTTO_NUMBERS_SIZE || numbers.size() > LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 지정된 개수보다 많거나 적을 수 없습니다. 개수: " + numbers.size());
        }
    }

    private void validateBonusIsNotDuplicated(final Set<LottoNumber> numbers, final LottoNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("로또 번호에 있는 번호는 보너스 번호로 사용 할 수 없습니다. 번호: " + bonus.value());
        }
    }

    public int matchCount(final Lotto otherLotto) {
        return (int)this.numbers
                .stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public boolean isMatchedBonus(final Lotto otherLotto) {
        return this.bonus.equals(otherLotto.bonus);
    }

    public List<Integer> extractLottoNumbers() {
        return this.numbers
                .stream()
                .map(LottoNumber::value)
                .collect(Collectors.toList());
    }

    public int extractBonusNumber() {
        return this.bonus.value();
    }

    public static Lotto from(final int[] numbers, final int bonus) {
        final Set<LottoNumber> lottoNumbers = toLottoNumbers(numbers);
        final LottoNumber bonusNumber = new LottoNumber(bonus);

        validateNumbersAreNotDuplicated(numbers, lottoNumbers);

        return new Lotto(lottoNumbers, bonusNumber);
    }

    private static Set<LottoNumber> toLottoNumbers(final int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static void validateNumbersAreNotDuplicated(final int[] numbers, final Set<LottoNumber> lottoNumbers) {
        if (numbers.length != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다. 번호: " + Arrays.toString(numbers));
        }
    }
}
