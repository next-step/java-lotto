package lotto.data;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.ConstUtils.LOTTO_WON_UNIT;

public class LottoPurchaseInfo {

    private final int purchasedPrice;
    private final List<Lotto> manualLotto;

    public LottoPurchaseInfo(int purchasedPrice, List<List<Integer>> manualLottoInput) {
        validatePurchasedPrice(purchasedPrice);
        this.purchasedPrice = purchasedPrice;

        this.manualLotto = new ArrayList<>();
        manualLottoInput.forEach(lotto -> this.manualLotto.add(new Lotto(lotto)));

        validatePurchasedPriceAndManualLotto(this.purchasedCount(), this.countManual());
    }

    private void validatePurchasedPrice(int purchasedPrice) {
        if (purchasedPrice < 0) {
            throw new IllegalArgumentException("구매 금액은 음수일 수 없습니다.");
        }
    }

    private void validatePurchasedPriceAndManualLotto(int purchasedCount, int manualLottoCount) {
        if (purchasedCount < manualLottoCount) {
            throw new IllegalArgumentException("수동 구매 리스트의 개수가 총 구매 개수보다 클 수 없습니다.");
        }
    }

    public int purchasedCount() {
        return this.purchasedPrice / LOTTO_WON_UNIT;
    }

    public int countManual() {
        return this.manualLotto.size();
    }

    public int countAuto() {
        return this.purchasedCount() - this.countManual();
    }

    public List<Lotto> getManualLotto() {
        return List.copyOf(manualLotto);
    }
}
