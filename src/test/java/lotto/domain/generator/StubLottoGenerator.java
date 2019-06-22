package lotto.domain.generator;

import java.util.List;

public class StubLottoGenerator implements LottoGenerator {

    private final List<Integer> stubLotto;

    public StubLottoGenerator(List<Integer> stubLotto) {this.stubLotto = stubLotto;}

    @Override
    public List<Integer> generate() {

        return stubLotto;
    }
}