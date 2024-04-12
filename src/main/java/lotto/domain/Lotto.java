package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_LENGTH = 6;
    private Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public long countHits(Lotto others) {
        return others.getNumbers().stream()
                .filter(other -> numbers.contains(other))
                .count();
    }

    public boolean matchBonus(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("6자리가 아닌 로또번호가 입력되었습니다.");
        }
    }


    @Override
    public String toString() {
        return "" + numbers;
    }

}
