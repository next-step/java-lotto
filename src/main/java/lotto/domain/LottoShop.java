package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    private LottoShop() {
    }

    public static Lottos sellAutoLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        return new Lottos(IntStream.range(0, calculateLottoCount(purchaseAmount))
                .mapToObj(i -> (Lotto) new AutoLotto())
                .collect(Collectors.toList()));
    }

    public static Lottos sellLottosWithManualAndAuto(int purchaseAmount, Lottos manualLottos) {
        validateInputs(purchaseAmount, manualLottos);

        int remainAmount = calculateRemainingPurchaseAmount(purchaseAmount, manualLottos);
        if (remainAmount >= LOTTO_PRICE) {
            manualLottos.add(sellAutoLottos(remainAmount));
        }

        return manualLottos;
    }

    private static int calculateRemainingPurchaseAmount(int purchaseAmount, Lottos manualLottos) {
        return purchaseAmount - manualLottos.countAllLotto() * LOTTO_PRICE;
    }

    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private static void validateInputs(int purchaseAmount, Lottos manualLottoList) {
        validatePurchaseAmount(purchaseAmount);

        if (calculateRemainingPurchaseAmount(purchaseAmount, manualLottoList) < 0) {
            throw new IllegalArgumentException("구입금액을 초과한 로또를 구매할 수 없습니다");
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 로또 한장 가격보다 작을 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }
    }

}
