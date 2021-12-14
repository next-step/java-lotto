package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class PurchaseLottosRequest {
    private final int purchasingAmount;
    private final int manualPurchasingSize;

    private PurchaseLottosRequest(int purchasingAmount, int manualPurchasingSize) {
        this.purchasingAmount = purchasingAmount;
        this.manualPurchasingSize = manualPurchasingSize;
    }

    public static PurchaseLottosRequest of(int purchasingPrice, int manualPurchasingSize) {
        validate(purchasingPrice, manualPurchasingSize);
        return new PurchaseLottosRequest(purchasingPrice, manualPurchasingSize);
    }

    public int purchasingLottoSize() {
        return purchasingAmount / Lotto.PRICE;
    }

    public int manualPurchasingSize() {
        return manualPurchasingSize;
    }

    private static void validate(int purchasingPrice, int manualPurchasingSize) {
        validatePurchasePrice(purchasingPrice);
        validateManualPurchasingSize(purchasingPrice, manualPurchasingSize);
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (lessThanMinPrice(purchasePrice)) {
            throw new IllegalArgumentException(Lottos.MIN_LOTTO_PRICE + "원 이상의 가격이 전달되어야합니다.");
        }
        if (isInvalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(String.format("로또구입금액(%,d)은 %,d의 배수이어야합니다.", purchasePrice, Lotto.PRICE));
        }
    }

    private static void validateManualPurchasingSize(int purchasingPrice, int manualPurchasingSize) {
        if (manualPurchasingSize < 0) {
            throw new IllegalArgumentException(String.format("입력한 수동 로또의 갯수(%d)는 0개 이상이어야합니다.", manualPurchasingSize));
        }
        if (totalPurchasingSize(purchasingPrice) < manualPurchasingSize) {
            throw new IllegalArgumentException(
                    String.format("수동 로또의 갯수(%d)는 총 구입 로또 갯수(%d)를 넘어갈 수 없습니다.", manualPurchasingSize, totalPurchasingSize(purchasingPrice))
            );
        }
    }

    private static int totalPurchasingSize(int purchasingPrice) {
        return purchasingPrice / Lotto.PRICE;
    }

    private static boolean lessThanMinPrice(int purchasePrice) {
        return purchasePrice < Lottos.MIN_LOTTO_PRICE;
    }

    private static boolean isInvalidPrice(int purchasePrice) {
        return purchasePrice % Lotto.PRICE != 0;
    }
}
