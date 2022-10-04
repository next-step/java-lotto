package step02.domain;

import java.util.List;

public class LottoList {

    private final List<Lotto> value;

    public LottoList(List<Lotto> value) {
        validateIsEmpty(value);
        this.value = value;
    }

    public List<Lotto> getValue() {
        return value;
    }

    public int size() {
        return value.size();
    }

    private void validateIsEmpty(List<Lotto> value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("LottoList에는 최소 하나 이상의 로또가 필요합니다.");
        }
    }
}
