package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int size) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            lottos.add(new Lotto(NumbersGenerator.generate(6)));
        }

        return new Lottos(lottos);
    }
}
