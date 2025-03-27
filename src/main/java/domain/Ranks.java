package domain;

import java.util.List;

public class Ranks {
    private final List<Rank> value;

    public Ranks(List<Rank> value) {
        this.value = value;
    }

    public LottoStatistics toStatistics() {
        return new LottoStatistics(value);
    }
}