package step2;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos = new ArrayList<>();

    public Lottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public int count() {
        return lottos.size();
    }
}
