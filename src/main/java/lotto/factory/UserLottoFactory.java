package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.UserLotto;

public class UserLottoFactory {

    private static final int LOTTO_PRICE = 1000;

    private UserLottoFactory() {
    }

    public static int getLottoQuantity(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    public static List<UserLotto> from(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new UserLotto());
        }
        return lottos;
    }
}
