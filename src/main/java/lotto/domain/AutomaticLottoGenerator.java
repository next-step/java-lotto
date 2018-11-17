package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutomaticLottoGenerator implements LottoGenerator {

    private List<Lotto> lottos;
    private int numberOfBuy;

    public AutomaticLottoGenerator(int numberOfBuy) {
        this.numberOfBuy = numberOfBuy;
    }

    @Override
    public List<Lotto> create() {
        lottos = new ArrayList<>();
        for (int i = 0; i < numberOfBuy; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }
}
