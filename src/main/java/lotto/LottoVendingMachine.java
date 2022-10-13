package lotto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.LottoNumbers;

public class LottoVendingMachine {
    private static final int LOTTO_PRICE = 1000;

    public static int calculate(int amount) {
        return amount / LOTTO_PRICE;
    }

    public static LottoNumbers buy(int quantity) {
        return new LottoNumbers(IntStream.range(0, quantity)
                                         .boxed()
                                         .map(notUsed -> new LottoNumber(LottoNumberGenerator.generate()))
                                         .collect(Collectors.toUnmodifiableList()));
    }
}
