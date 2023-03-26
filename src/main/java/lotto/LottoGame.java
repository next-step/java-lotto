package lotto;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private static final long LOTTO_AMOUNT = 1000;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public int getAutoPurchaseCount(long amount, int manualPurchaseCount) {

        return (int) (amount / LOTTO_AMOUNT) - manualPurchaseCount;
    }

    public Lotto createManualLotto(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray());
    }

    public Lotto createAutoLotto() {
        List<Integer> numbers = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0 ,6).stream()
                .mapToInt(Integer::intValue).toArray());
    }
}
