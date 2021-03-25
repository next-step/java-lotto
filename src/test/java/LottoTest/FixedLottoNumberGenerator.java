package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;

import java.util.Arrays;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public LottoGame numbers() {
        return new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}
