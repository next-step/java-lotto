package step2.domain.lotto;

import step2.util.LottoNumberGenerator;
import java.util.List;

public class RandomStrategy implements LottoStrategy {

    @Override
    public List<Integer> createNumbers() {
        return LottoNumberGenerator.create();
    }
}
