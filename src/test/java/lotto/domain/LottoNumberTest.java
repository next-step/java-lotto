package lotto.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Nested
    class getLottoNumber_메서드는 {

        @Test
        void 숫자를_리턴한다() {
            LottoNumber lottoNumber = new LottoNumber(3);

            int actual = lottoNumber.getLottoNumber();

            assertThat(actual).isEqualTo(3);
        }
    }
}
