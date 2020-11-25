package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void testCreateLottoNumber(){
        LottoNumber lottoNumber = new LottoNumber(33);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(33));
    }

    @Test
    void testValidateLottoNumber(){
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_BALL_NUMBER_RANGE);

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ErrorMessage.INVALID_BALL_NUMBER_RANGE);
    }
}
