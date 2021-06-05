package lotto.shop;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;

public class NumberGenerator {
    private static final Random random = new Random();

    public static List<Integer> generate() {
        return IntStream.generate(() -> random.nextInt(LottoNumber.MAX_NUMBER) + LottoNumber.MIN_NUMBER)
                .distinct()
                .limit(Lotto.MAX_COUNT)
                .boxed()
                .collect(Collectors.toList());
    }
}