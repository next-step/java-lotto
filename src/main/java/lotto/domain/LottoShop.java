package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    private LottoShop() {
    }

    public static List<Lotto> sellLotto(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        return IntStream.range(0, calculateLottoCount(purchaseAmount))
                .mapToObj(i -> (Lotto) new AutoLotto())
                .collect(Collectors.toList());
    }

    public static List<Lotto> sellLotto(int purchaseAmount, List<Lotto> manualLottoList) {
        validateInputs(purchaseAmount, manualLottoList);

        return Stream.concat(
                        IntStream.range(0, calculateAutoLottoCount(purchaseAmount, manualLottoList))
                                .mapToObj(i -> (Lotto) new AutoLotto()),
                        manualLottoList.stream())
                .collect(Collectors.toList());
    }

    private static int calculateAutoLottoCount(int purchaseAmount, List<Lotto> manualLottoList) {
        return calculateLottoCount(purchaseAmount) - manualLottoList.size();
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private static void validateInputs(int purchaseAmount, List<Lotto> manualLottoList) {
        validatePurchaseAmount(purchaseAmount);

        if (calculateAutoLottoCount(purchaseAmount, manualLottoList) < 0) {
            throw new IllegalArgumentException("구입금액을 초과한 로또를 구매할 수 없습니다");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 로또 한장 가격보다 작을 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }
    }

}
