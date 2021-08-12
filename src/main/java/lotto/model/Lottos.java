package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount, List<Lotto> manualLottos) {
        validatePurchasableAmount(purchaseAmount);
        validatePurchasableManualLottoCount(purchaseAmount, manualLottos.size());

        int lottoCountTotal = purchaseAmount / LOTTO_PRICE;
        int autoLottoCount = lottoCountTotal - manualLottos.size();

        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new RandomLottoNumberGenerating()));
        }
        this.lottos = lottos;
    }

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void validatePurchasableAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("구입금액은 최소 %d(원) 이상이어야 합니다.", LOTTO_PRICE));
        }
    }

    private void validatePurchasableManualLottoCount(int purchaseAmount, int manualLottoCount) {
        if (manualLottoCount > purchaseAmount / LOTTO_PRICE) {
            throw new IllegalArgumentException("수동 로또 개수가 구입 가능 개수를 초과했습니다.");
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
