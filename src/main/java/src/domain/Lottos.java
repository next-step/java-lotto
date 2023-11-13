package src.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public List<Place> match(Lotto winningLotto) {
        List<Place> places = new ArrayList<>();
        for (Lotto lotto: values) {
            places.add(winningLotto.match(lotto));
        }

        return places;
    }

    public int size() {
        return values.size();
    }
}
