package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLottos {

    private final List<Lotto> lottos;

    public MyLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static MyLottos rollLottos(int input) {
        List<Lotto> array = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            array.add(new Lotto());
        }
        return new MyLottos(array);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public Integer getLottoSize() {
        return lottos.size();
    }
}
