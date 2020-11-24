package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    public void 임계치를_벗어난_로또_번호_체크() throws Exception {
        int threshold = TestUtils.getThreshold();
        assertThatIllegalArgumentException().isThrownBy(() ->new LottoNumber(threshold + 1));
    }

    @Test
    public void 정상_로또_번호_체크() throws Exception {
        int threshold = TestUtils.getThreshold();
        assertThat(new LottoNumber(threshold));
    }

}
