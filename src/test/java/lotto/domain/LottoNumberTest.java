package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        this.lottoNumber = new LottoNumber(3);
    }

    @Nested
    class 생성자는 {

        @Nested
        class 숫자가_아닌_문자열이_주어질경우 {

            @ParameterizedTest
            @ValueSource(strings = {
                    "a"
            })
            void IllegalArgumentException을_던진다(String notNumberString) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new LottoNumber(notNumberString));
            }
        }
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
