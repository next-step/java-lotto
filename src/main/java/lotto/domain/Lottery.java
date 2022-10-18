package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private final Lottos lottos;

    public Lottery(Integer amount) {
        this.lottos = drawLottery(amount);
    }

    public Lottos getLottos() {
        return lottos;
    }

    private Lottos drawLottery(Integer amount) {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto());
        }

        return new Lottos(lottoList);
    }
}
