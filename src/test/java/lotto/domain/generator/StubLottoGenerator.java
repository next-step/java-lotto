package lotto.domain.generator;

import java.util.List;

public class StubLottoGenerator implements LottoGenerator {

    private final List<Integer> stubLottoNumber;

    public StubLottoGenerator(List<Integer> stubLottoNumber) {this.stubLottoNumber = stubLottoNumber;}

    @Override
    public List<Integer> generate() {

        return stubLottoNumber;
    }
}