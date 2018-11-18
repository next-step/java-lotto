package lotto.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_DIGIT = 6;

    private Set<LottoNo> numbers;

    private Lotto(Set<LottoNo> numbers) {
        validation(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    public static Lotto from(Set<Integer> numbers) {
        Set<LottoNo> lotto = new HashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNo.from(number));
        }

        return new Lotto(lotto);
    }

    public Set<LottoNo> getNumbers() {
        return numbers;
    }

    public int matchCount(Lotto lotto) {
        lotto.numbers.retainAll(this.numbers);
        return lotto.numbers.size();
    }

    public boolean isBonusMatch(LottoNo bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private void validation(Set<LottoNo> numbers) {
        validationNumberDuplicate(numbers);
        validationNumberDigit(numbers);
    }

    private void validationNumberDuplicate(Set<LottoNo> numbers) {
        if(!numbers.stream().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("숫자는 중복하여 입력할 수 없습니다.");
        }
    }

    private void validationNumberDigit(Set<LottoNo> numbers) {
        if (numbers.size() != LOTTO_NUMBER_DIGIT) {
            throw new IllegalArgumentException("숫자는 6개 까지 입력하세요.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
