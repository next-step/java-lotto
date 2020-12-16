package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void LottoNumber유효성체크() {
        assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
    }

}
