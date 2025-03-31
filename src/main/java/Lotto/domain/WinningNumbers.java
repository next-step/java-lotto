package Lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static Lotto.domain.LottoList.LOTTO_PICK_COUNT;
import static Lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static Lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class WinningNumbers {
    private final Set<LottoNumber> numbers;

    public WinningNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Winning numbers must have 6 numbers.");
        }
        this.numbers = new HashSet<>(numbers);
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public static boolean isInvalidWinningNumbers(String input) {

        if (input == null || input.trim().isEmpty()) {
            return true;
        }

        String[] numbers = input.split(",");
        if (numbers.length != LOTTO_PICK_COUNT) {
            return true;
        }
        for (String number : numbers) {
            try {
                int n = Integer.parseInt(number.trim());
                if (n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    public static Set<LottoNumber> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
