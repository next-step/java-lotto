package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLottoNumbers() {
        return lotto;
    }

    @Override
    public String toString() {
        return "[" + lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}
