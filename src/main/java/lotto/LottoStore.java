package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStore {

    public static Lottos purchaseLotto(BigDecimal payment) {
        int itemNumbers = payment.divide(Lotto.PRICE).setScale(0, RoundingMode.FLOOR).intValue();
        return LottoGenerator.generateAutoLottos(itemNumbers);
    }
}
