package lotto;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonus;

    public WinningLotto(Set<LottoNumber> numbers, LottoNumber bonus) {
        validation(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validation(Set<LottoNumber> numbers, LottoNumber bonus) {
        if(numbers == null){
            throw new IllegalArgumentException("numbers cannot be null");
        }
        Set<LottoNumber> validSet = new HashSet<>(numbers);
        validSet.add(bonus);
        if (validSet.size() == numbers.size()){
            throw new IllegalArgumentException("보너스 숫자와 당첨 숫자는 중복되면 안됩니다");
        }

    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
