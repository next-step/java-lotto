package lotto.domain;

import lotto.common.exception.LottoServiceException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 넘버_범위가_틀리면_오류를_발생한다() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_RANGE.getDescription());
    }
}
