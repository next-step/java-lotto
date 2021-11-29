package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        if(number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public int getLottoNumber() {
        return number;
    }
}
