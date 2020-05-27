package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private static final int PRICE = 1000;

    public static List<Lotto> generateLottos(int totalPrice) {
        int lottoCount = totalPrice / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
