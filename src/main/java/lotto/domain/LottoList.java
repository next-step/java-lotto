package lotto.domain;

import java.util.List;
import java.util.Map;

public final class LottoList {
    private final List<Lotto> values;

    private LottoList(List<Lotto> values) {
        this.values = values;
    }

    public static LottoList newAuto(Number size) {
        return newAuto(size.intValue());
    }

    public static LottoList newAuto(int size) {
        return null;
    }

    public int size() {
        return values.size();
    }
}
