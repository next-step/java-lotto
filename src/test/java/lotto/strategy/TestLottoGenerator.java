package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    private final List<LottoNumber> number;

    public TestLottoGenerator(List<LottoNumber> number) {
        this.number = number;
    }

    @Override
    public List<LottoNumber> lotto() {
        return number;
    }
}
