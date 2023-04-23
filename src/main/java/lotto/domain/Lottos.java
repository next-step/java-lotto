package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    public static long LOTTO_PRICE = 1_000;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(long price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 " + LOTTO_PRICE + "의 금액부터 구매가 가능합니다. 주문금액: " + price);
        }

        for (int i = 0; i < price / LOTTO_PRICE; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public Lottos(Lotto... lottos) {
        Collections.addAll(this.lottos, lottos);
    }

    public List<Lotto> lottos() {
        return this.lottos;
    }

    public long purchaseAmount() {
        return LOTTO_PRICE * purchaseQuantity();
    }

    public int purchaseQuantity() {
        return this.lottos.size();
    }
}
