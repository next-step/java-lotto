package step2.model;

import java.util.List;

public class Lotto {
    public List<Integer> getLotto(LottoStrategy lottoStrategy) {
        return lottoStrategy.getLotto();
    }
}
