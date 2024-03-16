package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {

    private List<Lotto> lottos;

    public void rollLottos(int input) {
        lottos = new ArrayList<>();

        for (int i = 0; i < input; i++) {
            lottos.add(new Lotto());
        }

    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
