package step02.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {

    private final List<Lotto> value = new ArrayList<>();

    public LottoList(List<Lotto> value) {
        validateIsEmpty(value);
        this.value.addAll(value);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(value);
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
