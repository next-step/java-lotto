package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {
    public static final int LOTTO_PURCHASE_AMOUNT = 1000;
    public static final String LOTTO_NUMBER_DELIMITER = ", ";

    public LottoBundle purchase(final Money money) {
        return LottoBundle.createAutoLottoBundle(money.calculatePurchases(LOTTO_PURCHASE_AMOUNT));
    }

    public LottoBundle purchase(final List<String> manualLottoBundle) {
        return LottoBundle.createManualLottoBundle(
            manualLottoBundle.stream()
                .map(string -> Lotto.createManualLotto(string, LOTTO_NUMBER_DELIMITER))
                .collect(Collectors.toUnmodifiableList())
        );
    }
}
