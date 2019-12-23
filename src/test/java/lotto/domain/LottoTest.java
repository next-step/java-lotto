package lotto.domain;

import lotto.common.exception.LottoServiceException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 사이즈가_6이_아니면_오류를_내보낸다() {
        Set<LottoNumber> number = new HashSet<>();
        number.add(LottoNumber.of(1));
        number.add(LottoNumber.of(2));
        number.add(LottoNumber.of(3));
        number.add(LottoNumber.of(4));
        number.add(LottoNumber.of(6));
        number.add(LottoNumber.of(7));
        number.add(LottoNumber.of(5));
        assertThatThrownBy(() -> Lotto.of(number)).isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_NUMBER_SIZE.getDescription());
    }
}
