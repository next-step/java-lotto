package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator extends Generating {

    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_SELECTION_COUNT = 6;

    public LottoGenerator() {
        this.setGenerableStrategy(new RandomGenerableStrategy());
    }

    public List<List<Integer>> generateLottos(int lottoCount) {

        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            lottos.add(this.generate(LOTTO_SELECTION_COUNT));
        }
        return lottos;
    }
}
