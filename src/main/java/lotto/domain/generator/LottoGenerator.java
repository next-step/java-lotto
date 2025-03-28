package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;

    private LottoGenerator() {
    }

    public static List<Lotto> generateLottoListByPurchaseAmount(int purchaseAmount) {
        validateInputs(purchaseAmount);

        return IntStream.range(0, calculateLottoCount(purchaseAmount))
                .mapToObj(i -> Lotto.generateRandomly())
                .collect(Collectors.toList());
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private static void validateInputs(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 로또 한장 가격보다 작을 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }
    }

}
