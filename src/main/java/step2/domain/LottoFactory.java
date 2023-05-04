package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int PRICE = 1000;

    private LottoFactory() {
    }

    public static PurchasedLotto of(int money, int manualLottoCount) {
        validateInput(money);
        int autoLottoPurchasedMoney = money - manualLottoCount * PRICE;
        return toPurchasedLotto(autoLottoPurchasedMoney);
    }

    private static PurchasedLotto getPurchasedLotto(int money) {
        List<Lotto> lottoStore = new ArrayList<>();
        int totalCount = money / PRICE;

        for (int i = 0; i < totalCount; i++) {
            Lotto lotto = Lotto.issue();
            lottoStore.add(lotto);
        }
        return new PurchasedLotto(lottoStore);
    }

    private static void validateInput(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private static PurchasedLotto toPurchasedLotto(int autoLottoPurchasedMoney) {
        return autoLottoPurchasedMoney < PRICE
            ? new PurchasedLotto()
            : getPurchasedLotto(autoLottoPurchasedMoney);
    }
}
