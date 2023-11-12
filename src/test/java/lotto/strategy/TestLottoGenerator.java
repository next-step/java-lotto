package lotto.strategy;

import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    private final List<Integer> number;

    public TestLottoGenerator(List<Integer> number) {
        this.number = number;
    }

    @Override
    public List<Integer> lotto() {
        return number;
    }
}
