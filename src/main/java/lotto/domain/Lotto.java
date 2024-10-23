package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final Set<Integer> numbers;
    private final int REQUIRED_NUMBERS = 6;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() != REQUIRED_NUMBERS) {
            throw new IllegalArgumentException("로또번호는 " + REQUIRED_NUMBERS + "개여야 합니다.");
        }
        this.numbers = new HashSet<>(numbers);
        if(this.numbers.size() != REQUIRED_NUMBERS) {
            throw  new IllegalArgumentException("로또번호는 중복될 수 없습니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public LottoDetailMatch countMatches(Lotto winningNumbers, int bonusNumber) {
        int matchCount = (int) numbers.stream()
                                .filter(winningNumbers.getNumbers()::contains)
                                .count();

        boolean isMatchedBonusNumber = bonusNumber != 0 && numbers.contains(bonusNumber);

        return new LottoDetailMatch(matchCount, isMatchedBonusNumber) ;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
