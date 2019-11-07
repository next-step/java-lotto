package com.seok2.lotto.domain;

import com.seok2.lotto.exception.LottoLengthException;
import java.util.Arrays;

public class LottoSheetRow {

    static final LottoSheetRow AUTO = new LottoSheetRow(new int[]{});
    private final int[] numbers;

    private LottoSheetRow(int[] numbers) {
        this.numbers = numbers;
    }

    static LottoSheetRow of(String... numbers) {
        int[] parsed = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .mapToInt(i -> i)
            .toArray();
        return of(parsed);
    }

    static LottoSheetRow of(int... numbers) {
        validate(numbers);
        return new LottoSheetRow(numbers);
    }

    private static void validate(int[] numbers) {
        if (numbers.length != Lotto.LOTTO_LENGTH) {
            throw new LottoLengthException();
        }
    }

    Lotto exchange() {
        return Lotto.of(Auto.FALSE, numbers);
    }

    boolean isAuto() {
        return numbers.length == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoSheetRow that = (LottoSheetRow) o;
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
