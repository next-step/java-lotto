package step4.domain.lotto;

import step4.util.LottoNumberGenerator;
import java.util.List;

public class RandomStrategy implements LottoStrategy {

    @Override
    public List<LottoNumber> createNumbers() {
        return LottoNumberGenerator.create();
    }
}
