package lotto;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private final Set<Integer> numbers;
    private final int bonus;

    public WinningLotto(Set<Integer> numbers, int bonus) {
        validation(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validation(Set<Integer> numbers, int bonus) {
        if(numbers == null){
            throw new IllegalArgumentException("numbers cannot be null");
        }
        Set<Integer> validSet = new HashSet<>(numbers);
        validSet.add(bonus);
        if (validSet.size() == numbers.size()){
            throw new IllegalArgumentException("보너스 숫자와 당첨 숫자는 중복되면 안됩니다");
        }

    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
