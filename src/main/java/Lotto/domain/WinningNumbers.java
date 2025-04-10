package Lotto.domain;

import Lotto.utils.ValidationUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static Lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;
import static Lotto.domain.Lottos.*;

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

    public static boolean isInvalidWinningNumbers(String input) {
        String[] numbers = input.split(",");
        return numbers.length != LOTTO_PICK_COUNT ||
                Arrays.stream(numbers).anyMatch(number -> ValidationUtils.isInvalidNumber(number, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
    }
}
