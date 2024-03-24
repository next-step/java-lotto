package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranks {
    private final List<Rank> values = new ArrayList<>();

    public Ranks(List<Rank> values) {
        if (values != null && !values.isEmpty()) {
            this.values.addAll(values);
        }
    }

    public List<Rank> values() {
        return Collections.unmodifiableList(values);
    }
}
