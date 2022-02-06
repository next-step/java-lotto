package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoFactory {

    private final static int LOTTO_PRICE = 1000;

    private LottoFactory() {
    }

    public static int getLottoQuantity(int purchasePrice) {
        if (isLowerThanLeastPrice(purchasePrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    private static boolean isLowerThanLeastPrice(int price) {
        return price < LOTTO_PRICE;
    }

    public static List<Lotto> from(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
