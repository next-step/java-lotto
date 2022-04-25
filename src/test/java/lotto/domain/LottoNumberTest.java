package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        this.lottoNumber = new LottoNumber(3);
    }

    @Nested
    class getLottoNumber_메서드는 {

        @Test
        void 숫자를_리턴한다() {
            int actual = lottoNumber.getLottoNumber();

            assertThat(actual).isEqualTo(3);
        }
    }

    @Nested
    class toString_메서드는 {

        @Test
        void 숫자의_문자형을_리턴한다() {
            String actual = lottoNumber.toString();

            assertThat(actual).isEqualTo("3");
        }
    }
}
