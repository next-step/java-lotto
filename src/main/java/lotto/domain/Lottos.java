package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 " + LOTTO_PRICE + "의 금액부터 구매가 가능합니다. 주문금액: " + price);
        }

        for (int i = 0; i < price / LOTTO_PRICE; i++) {
            lottos.add(new Lotto());
        }
    }


    public List<Lotto> lottos() {
        return this.lottos;
    }
}
