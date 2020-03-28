package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int PRICE_PER_PIECE = 1000;

    public List<Lotto> buyAuto(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = Math.floorDiv(price, PRICE_PER_PIECE);

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }
}
