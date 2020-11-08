package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoFactory {
    public List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (; amount >= 1000; amount -= 1000) {
            lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }

        return lottos;
    }
}
