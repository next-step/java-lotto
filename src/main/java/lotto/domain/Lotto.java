package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers){
        validationCheck(numbers);
        this.numbers = numbers;
    }

    public Rank matchWith(WinningNumbers winningNumbers){
        int count = (int) numbers.stream()
                .filter(winningNumbers::hasNumber)
                .count();
        return Rank.findByCountAndBonus(count, numbers.contains(winningNumbers.getBonusNumber()));
    }

    private void validationCheck(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
    
    public boolean contains(LottoNumber number){
        return numbers.contains(number);
    }
}
