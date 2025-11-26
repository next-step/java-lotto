package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this(createLottos(count));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }

    private static List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
