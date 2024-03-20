package lottoTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    @DisplayName("로또는 1미만 45초과 시 IllegalArgumentException")
    void LOTTO_NUMBER_LEAST_ONE_MAXIMUM_45(){
        assertThatThrownBy(()->new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
