package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutomaticLottoGenerator implements LottoGenerator {

    private int numberOfBuy;

    public AutomaticLottoGenerator(int numberOfBuy) {
        this.numberOfBuy = numberOfBuy;
    }

    @Override
    public List<Lotto> create() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfBuy; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }
}
