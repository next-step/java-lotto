package step3.domain.lotto;

import step3.util.LottoNumberGenerator;
import java.util.List;

public class RandomStrategy implements LottoStrategy {

    @Override
    public List<LottoNumber> createNumbers() {
        return LottoNumberGenerator.create();
    }
}
