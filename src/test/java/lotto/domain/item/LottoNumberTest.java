package lotto.domain.item;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumberTest {

    @DisplayName("1 ~ 45 사이의 숫자가 아니면 exception이 발생한다")
    @Test
    public void create_fail_outOfRange() throws Exception {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(50)).isInstanceOf(ValidLottoException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(ValidLottoException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(-10)).isInstanceOf(ValidLottoException.class)
        );
    }
}
