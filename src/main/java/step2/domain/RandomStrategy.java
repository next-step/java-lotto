package step2.domain;

import step2.util.LottoNumberGenerator;
import java.util.List;

public class RandomStrategy implements LottoNumberStrategy {

    @Override
    public List<Integer> createNumbers() {
        return LottoNumberGenerator.create();
    }
}
