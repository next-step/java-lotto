package lotto.domain;

import lotto.common.exception.LottoServiceException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 사이즈가_6이_아니면_오류를_내보낸다() {
        Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        number.add(7);
        assertThatThrownBy(() -> Lotto.of(number)).isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_NUMBER_SIZE.getDescription());
    }

    @Test
    void 숫자_1부터_45가_아니면_오류를_내보낸다() {
        Set<Integer> number = new HashSet<>();
        number.add(0);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        assertThatThrownBy(() -> Lotto.of(number)).isInstanceOf(LottoServiceException.class)
                .hasMessage(LottoError.WRONG_LOTTO_RANGE.getDescription());
    }
}
