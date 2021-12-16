package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseLottosRequest {
    private final int purchasingAmount;
    private final List<ManualLottoRequest> manualPurchasingLottos;

    private PurchaseLottosRequest(int purchasingAmount, List<ManualLottoRequest> manualPurchasingLottos) {
        this.purchasingAmount = purchasingAmount;
        this.manualPurchasingLottos = manualPurchasingLottos;
    }

    public static PurchaseLottosRequest of(int purchasingPrice, List<ManualLottoRequest> manualPurchasingLottos) {
        validate(purchasingPrice, manualPurchasingLottos);
        return new PurchaseLottosRequest(purchasingPrice, manualPurchasingLottos);
    }

    public List<Lotto> manualLottos() {
        return manualPurchasingLottos.stream()
                .map(ManualLottoRequest::toLotto)
                .collect(Collectors.toList());
    }

    public int automatedLottoSize() {
        return purchasingLottoSize() - manualPurchasingLottoSize();
    }

    private int purchasingLottoSize() {
        return purchasingAmount / Lotto.PRICE;
    }

    private int manualPurchasingLottoSize() {
        return manualPurchasingLottos.size();
    }

    private static void validate(int purchasingPrice, List<ManualLottoRequest> manualPurchasingLottos) {
        validatePurchasePrice(purchasingPrice);
        validateManualPurchasingLottos(purchasingPrice, manualPurchasingLottos);
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (lessThanMinPrice(purchasePrice)) {
            throw new IllegalArgumentException(Lottos.MIN_LOTTO_PRICE + "원 이상의 가격이 전달되어야합니다.");
        }
        if (isInvalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(String.format("로또구입금액(%,d)은 %,d의 배수이어야합니다.", purchasePrice, Lotto.PRICE));
        }
    }

    private static void validateManualPurchasingLottos(int purchasingPrice, List<ManualLottoRequest> manualPurchasingLotto) {
        int totalManualPurchasingLottoSize = manualPurchasingLotto.size();
        if (totalPurchasingSize(purchasingPrice) < totalManualPurchasingLottoSize) {
            throw new IllegalArgumentException(
                    String.format("수동 로또의 갯수(%d)는 총 구입 로또 갯수(%d)를 넘어갈 수 없습니다.", totalManualPurchasingLottoSize, totalPurchasingSize(purchasingPrice))
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
