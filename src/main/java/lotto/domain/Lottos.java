package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> elements = new ArrayList<>();

    public int size() {
        return elements.size();
    }

    public void add(Lotto lotto) {
        this.elements.add(lotto);
    }
}
