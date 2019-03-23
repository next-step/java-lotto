package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 구입_금액에_따라_로또_발급개수가_결정되는지() {

        LottoList lottoList = LottoMachine.purchase(14000);

        assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test(expected = RuntimeException.class)
    public void 로또의_각_번호는_유일한지() {
        new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5)));
    }
}
