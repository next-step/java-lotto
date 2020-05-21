package lotto.domain.rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranks {
    private List<Rank> values;

    private Ranks(List<Rank> values) {
        this.values = values;
    }

    public static Ranks create(List<Rank> values) {
        return new Ranks(Collections.unmodifiableList(new ArrayList<>(values)));
    }

    public int size() {
        return this.values.size();
    }

    public long calculateTotalPrize() {
        return values.stream().mapToLong(Rank::getPrice).sum();
    }

    public long getCount(Rank rank) {
        return values.stream()
                .filter(value -> value.equals(rank))
                .count();
    }
}
