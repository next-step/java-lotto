package lotto;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> value;

    public LottoNumbers(List<Integer> value) {
        this.value = value;
    }

    public List<Integer> getValue() {
        return value;
    }
}
