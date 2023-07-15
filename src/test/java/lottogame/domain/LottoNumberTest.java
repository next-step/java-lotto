package lottogame.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoNumber 클래스")
class LottoNumberTest {

    @Nested
    @DisplayName("new 생성자는")
    class Describe_NewConstructor {

        @Nested
        @DisplayName("1~45사이의 값이 들어오면,")
        class Context_Input_1_Between_45 {

            private static final int MINIMUM_LOTTO_NUMBER = 1;
            private static final int MAXIMUM_LOTTO_NUMBER = 45;

            @Test
            @DisplayName("생성을 성공한다.")
            void It_Create_Success() {
                assertThatNoException().isThrownBy(() -> LottoNumber.valueOf(MINIMUM_LOTTO_NUMBER));
                assertThatNoException().isThrownBy(() -> LottoNumber.valueOf(MAXIMUM_LOTTO_NUMBER));
            }
        }

        @Nested
        @DisplayName("1~45 밖의 값이 들어오면,")
        class Context_Input_Not_1_Between_45 {

            private static final int MINIMUM_LOTTO_NUMBER = 0;
            private static final int MAXIMUM_LOTTO_NUMBER = 46;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Create_Success() {
                assertThatThrownBy(() -> LottoNumber.valueOf(MINIMUM_LOTTO_NUMBER)).isInstanceOf(
                    IllegalArgumentException.class);
                assertThatThrownBy(() -> LottoNumber.valueOf(MAXIMUM_LOTTO_NUMBER)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("equals는")
    class Describe_Equals {

        @Nested
        @DisplayName("같은 값이면")
        class Context_Same_Lotto_Number {

            private final LottoNumber lottoNumber = LottoNumber.valueOf(1);
            private final LottoNumber sameLottoNumber = LottoNumber.valueOf(1);

            @Test
            @DisplayName("true를 반환한다")
            void It_Return_True() {
                assertThat(lottoNumber).isEqualTo(sameLottoNumber);
            }
        }
    }
}
