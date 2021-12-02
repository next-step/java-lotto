package lotto.model;

import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount, List<LottoNumbers> manualLottoNumbers) {
        int autoLottoCount = purchaseAmount / LOTTO_PRICE - manualLottoNumbers.size();
        return new Lotto(manualLottoNumbers, autoLottoCount);
    }
}
