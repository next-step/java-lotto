package lotto.domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private static final int LOTTO_PRICE = 1000;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static int getLottoCount(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000의 배수여야 함");
        }

        return totalPrice / LOTTO_PRICE;
    }
}
