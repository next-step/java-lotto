package step2.domain;

import static step2.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator extends Generating {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_SELECTION_COUNT = 6;

    public LottoGenerator() {
        this.setGenerableStrategy(new RandomGenerableStrategy());
    }

    public List<Lotto> generateLottos(int price) {
        int lottoCount = getLottoCount(price);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            lottos.add(this.generate(LOTTO_SELECTION_COUNT));
        }
        return lottos;
    }

    private int getLottoCount(int price) {
        if (price < LOTTO_PRICE) {
            return 0;
        }
        return (int) Math.floor(price) / LOTTO_PRICE;
    }
}
