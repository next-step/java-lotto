package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    public static int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoes = new ArrayList<>();

    public Lottoes(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또는 " + LOTTO_PRICE + "의 금액부터 구매가 가능합니다. 주문금액: " + price);
        }

        for (int i = 0; i < price / LOTTO_PRICE; i++) {
            lottoes.add(new Lotto());
        }
    }


    public List<Lotto> lottoes() {
        return this.lottoes;
    }
}
