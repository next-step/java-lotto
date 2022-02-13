package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;

public class UserLottoFactory {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private UserLottoFactory() {
    }

    public static int getLottoQuantity(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE.intValue()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return new BigDecimal(purchasePrice).divide(LOTTO_PRICE, RoundingMode.FLOOR).intValue();
    }

    public static List<UserLotto> from(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new UserLotto());
        }
        return lottos;
    }
}
