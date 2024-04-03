package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static List<Lotto> purchaseLotto(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / 1000; i++) {
            lottoList.add(new Lotto());
        }

        return lottoList;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 음수가 될 수 없습니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 구입할 수 있습니다.");
        }
    }
}
