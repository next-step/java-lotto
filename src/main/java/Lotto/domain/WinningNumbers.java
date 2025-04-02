package Lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Lotto.constants.LottoConstants.LOTTO_PICK_COUNT;


public class WinningNumbers {
    private final Set<LottoNumber> numbers;

    public WinningNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6자리여야 합니다.");
        }
        this.numbers = new HashSet<>(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }
}
