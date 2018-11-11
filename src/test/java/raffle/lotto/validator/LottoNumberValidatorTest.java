package raffle.lotto.validator;

import org.junit.Test;
import raffle.lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class LottoNumberValidatorTest {

    @Test(expected = RuntimeException.class)
    public void 로또_범위의_숫자_체크() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 6, 5, 44, 22, 77)));

        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoNumberValidator.validator(lottos);
    }

}