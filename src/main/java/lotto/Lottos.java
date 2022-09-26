package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> values = new ArrayList<>();

    public Lottos(int num) {
        for (int i = 0; i < num; i++) {
            values.add(Lotto.create());
        }
    }

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public List<Lotto> values() {
        return Collections.unmodifiableList(values);
    }
}
