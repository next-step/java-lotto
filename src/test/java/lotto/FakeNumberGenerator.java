package lotto;

import java.util.List;

public class FakeNumberGenerator  implements LottoNumberGenerator{
    private final List<List<Integer>> fixed;
    private int index = 0;

    public FakeNumberGenerator(List<List<Integer>> fixed) {
        this.fixed = fixed;
    }

    @Override
    public List<Integer> generate() {
        return fixed.get(index++);
    }
}
