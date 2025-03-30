package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int purchasePrice) {
        lottos = new ArrayList<>();
        int purchaseAmount = purchasePrice / 1000;
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(new RandomLottoNumberGenerator()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int count() {
        return lottos.size();
    }
}
