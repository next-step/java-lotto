package lotto.domain;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static List<Integer> setUp() {
        List<Integer> numbers = new ArrayList<>();

        IntStream.range(Constant.MIN_LOTTO, Constant.MAX_LOTTO + 1)
                .forEach(numbers::add);

        return numbers;
    }
}
