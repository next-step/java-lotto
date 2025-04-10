package Lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Lotto.domain.Lottos.*;

public class WinningNumbers {
    private final Set<LottoNumber> numbers;

    public WinningNumbers(List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 " + LOTTO_PICK_COUNT + "자리여야 합니다.");
        }
        this.numbers = new HashSet<>(numbers);
        if (this.numbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("중복된 번호는 허용되지 않습니다.");
        }
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }
}
