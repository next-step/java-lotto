package lotto;

import java.util.List;

public class LottoOutlet {
    private static final int LOTTO_PRICE = 1000;

    public static int lottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public static Lotto generateLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}
