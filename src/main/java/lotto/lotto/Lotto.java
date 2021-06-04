package lotto.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.error.ErrorMessage;

public class Lotto {
    public static final int MAX_COUNT = 6;
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumber(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public int matchingCount(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber.numbers()::contains)
                .count();
    }

    public Set<LottoNumber> numbers() {
        return numbers;
    }

    public boolean isContainBonus(LottoNumber bonusNumber) {
        return numbers.stream().anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    public static Lotto of(int ...numbers) {
        return new Lotto(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()));
    }

    private void checkNumber(List<Integer> numbers) {
        if (numbers.size() != MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }

    private static void checkNumber(int ...numbers) {
        if (numbers.length != MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT);
        }
    }
}
