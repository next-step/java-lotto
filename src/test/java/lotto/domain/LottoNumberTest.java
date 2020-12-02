package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("범위 밖의 로또 넘버 생성 시 IllegalArgumentException 발생")
    public void outOfBoundTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46))
                .withMessage(LottoNumber.OUT_BOUND_MESSAGE);
    }
}
