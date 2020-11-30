package domain;

import common.CommonConstants;
import exception.InvalidLottoNumbersException;
import exception.NumberNotInRangeException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1_000;


    private final LottoNumbers numbers;

    private Lotto(LottoNumbers numbers) {
        Objects.requireNonNull(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(new LottoNumbers(numbers));
    }

    public static Lotto of(String numbers) {
        return Lotto.of(Arrays.stream(numbers.split(CommonConstants.SPLIT_DELIMITER_COMMA))
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
