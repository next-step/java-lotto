package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendingMachine {
    private static final int LOTTO_PRICE = 1000;

    public static List<LottoNumber> buy(int amount) {
        int quantity = amount / LOTTO_PRICE;

        return IntStream.range(0, quantity)
                        .boxed()
                        .map(notUsed -> new LottoNumber(LottoNumberGenerator.generate()))
                        .collect(Collectors.toUnmodifiableList());
    }
}
