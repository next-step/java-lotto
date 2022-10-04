package step02.domain;

import java.util.List;

public class LottoList {

    private final List<Lotto> value;

    public LottoList(List<Lotto> value) {
        this.value = value;
    }

    public List<Lotto> getValue() {
        return value;
    }

    public int size() {
        return value.size();
    }
}
