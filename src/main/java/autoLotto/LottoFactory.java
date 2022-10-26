package autoLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> makeLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }

        int quantity = amount / LOTTO_PRICE;
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }
}
