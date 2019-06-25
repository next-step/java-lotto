package lotto.domain;

import lotto.domain.generator.AutoLottoNumbersGenerator;
import lotto.domain.generator.LottoNumbersGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoNumbersTest {
    @Test
    void 로또번호_항상_6개() {
        LottoNumbersGenerator generator = new AutoLottoNumbersGenerator();
        assertThat(new LottoNumbers(generator).getLottoNumbers()).size().isEqualTo(6);
    }
}
