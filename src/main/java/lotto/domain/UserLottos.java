package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UserLottos {

    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private final List<UserLotto> userLottos;

    public UserLottos(int quantity) {
        this.userLottos = createUserLottos(quantity);
    }

    public static int getLottoQuantity(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE.intValue()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return new BigDecimal(purchasePrice).divide(LOTTO_PRICE, RoundingMode.FLOOR).intValue();
    }

    private List<UserLotto> createUserLottos(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new UserLotto());
        }
        return lottos;
    }

    public List<UserLotto> getRawUserLottos() {
        return new ArrayList<>(userLottos);
    }
}
