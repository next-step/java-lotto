package raffle.domain.lotto.validator;

import org.junit.Test;
import raffle.domain.lotto.Lotto;
import raffle.domain.lotto.LottoNo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberValidatorTest {

    @Test(expected = RuntimeException.class)
    public void 로또_범위의_숫자_체크() {
        String lottoNo = "1, 6 , 14 , 44 , 36 , 77";
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.stream(lottoNo.split(", ")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList())));

        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoNumberValidator.validator(lottos);
    }

}