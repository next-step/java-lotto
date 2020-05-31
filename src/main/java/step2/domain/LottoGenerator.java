package step2.domain;

import static step2.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator extends Generating {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_SELECTION_COUNT = 6;

    public LottoGenerator(GenerableStrategy generableStrategy) {
        super(generableStrategy);
    }

    public List<Lotto> generateLottos(UserPrice userPrice) {
        int lottoCount = getLottoCount(userPrice);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            lottos.add(new Lotto(this.generate(LOTTO_SELECTION_COUNT)));
        }
        return lottos;
    }

    private int getLottoCount(UserPrice userPrice) {
        if (userPrice.getPrice() < LOTTO_PRICE) {
            return 0;
        }
        return (int) Math.floor(userPrice.getPrice()) / LOTTO_PRICE;
    }
}
