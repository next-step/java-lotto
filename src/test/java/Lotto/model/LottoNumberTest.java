package Lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @Test
    void shouldNotAllowLottoNumber_WhenNumberIsBelow1(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->new LottoNumber(0))
                .withMessage("The Lotto number must be between 1 and 45.");
    }

    @Test
    void shouldNotAllowLottoNumber_WhenNumberIsAbove45(){
        assertThatIllegalArgumentException()
                .isThrownBy(() ->new LottoNumber(46))
                .withMessage("The Lotto number must be between 1 and 45.");
    }

    @Test
    void shouldAllowLottoNumber_WhenNumberIsBetween1and45(){
        LottoNumber lottoNumber = new LottoNumber(45);
        assertThat(lottoNumber.value()).isEqualTo(45);
    }
}
