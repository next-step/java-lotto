package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoFactory {
    private static final int PRICE_OF_ONE_LOTTO = 1_000;

    public List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (; amount >= PRICE_OF_ONE_LOTTO; amount -= PRICE_OF_ONE_LOTTO) {
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }

        return lottos;
    }
}
