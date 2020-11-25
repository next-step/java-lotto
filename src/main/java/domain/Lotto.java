package domain;

import common.CommonConstants;
import exception.InvalidLottoNumbersException;
import exception.NumberNotInRangeException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) throws Exception {
        if(numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidLottoNumbersException();
        }

        if(numbers.stream().anyMatch(i -> i < LOTTO_MIN_NUMBER || i > LOTTO_MAX_NUMBER)) {
            throw new NumberNotInRangeException();
        }

        return new Lotto(numbers);
    }

    public static Lotto of(String numbers) throws Exception {
        return Lotto.of(Arrays.stream(numbers.split(CommonConstants.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public LottoPrize checkWhetherToWin(Lotto winningLotto, int bonusNumber) {
        int count = (int) winningLotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();

        return LottoPrize.of(count, hasBonus(bonusNumber));
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
