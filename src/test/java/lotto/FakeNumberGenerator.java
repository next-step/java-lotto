package lotto;

import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;

public class FakeNumberGenerator  implements LottoNumberGenerator {
    private final List<List<Integer>> fixed;
    private int index = 0;

    public FakeNumberGenerator(List<List<Integer>> fixed) {
        if (fixed == null || fixed.isEmpty()) {
            throw new IllegalArgumentException("fixed numbers must not be empty");
        }
        this.fixed = fixed;
    }

    @Override
    public List<Integer> generate() {
        if (index >= fixed.size()) {
            throw new IllegalStateException("No more fixed numbers. index=" + index);
        }
        return fixed.get(index++);
    }
}
