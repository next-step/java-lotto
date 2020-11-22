package domain;

import exception.InvalidLottoNumbersException;

import java.util.*;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_PRICE = 1_000;

    private List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) throws Exception {
        if(numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidLottoNumbersException();
        }

        return new Lotto(numbers);
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
