package step2.streategy;

import step2.domain.lotto.LottoNumber;
import step2.strategy.NumberMakeStrategy;

import java.util.List;
import java.util.Set;

public class TestNumberMakeStrategy implements NumberMakeStrategy {
    private Set<LottoNumber> markingNumbers;

    @Override
    public Set<LottoNumber> create() {
        return markingNumbers;
    }

    public void setupTestValue(Set<LottoNumber> input){
        markingNumbers = input;
    }
}
