package com.seok2.lotto.domain.order;

import com.seok2.common.utils.ArrayUtils;
import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.exception.LottoLengthException;
import java.util.Arrays;

public class LottoSheetRow {

    static final LottoSheetRow AUTO = new LottoSheetRow(new int[]{});

    private final int[] numbers;

    private LottoSheetRow(int[] numbers) {
        this.numbers = numbers;
    }

    public static LottoSheetRow manual(String... numbers) {
        int[] parsed = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .mapToInt(i -> i)
            .toArray();
        return manual(parsed);
    }

    public static LottoSheetRow manual(int... numbers) {
        validate(numbers);
        return new LottoSheetRow(numbers);
    }

    private static void validate(int[] numbers) {
        if (numbers.length != Lotto.LENGTH) {
            throw new LottoLengthException();
        }
    }

    public Lotto exchange() {
        return Lotto.manual(numbers);
    }

    public boolean isAuto() {
        return ArrayUtils.isEmpty(numbers);
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
