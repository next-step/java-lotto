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

            private final int minimumLottoNumber = 1;
            private final int maximumLottoNumber = 45;

            @Test
            @DisplayName("생성을 성공한다.")
            void It_Create_Success() {
                assertThatNoException().isThrownBy(() -> new LottoNumber(minimumLottoNumber));
                assertThatNoException().isThrownBy(() -> new LottoNumber(maximumLottoNumber));
            }
        }

        @Nested
        @DisplayName("1~45 밖의 값이 들어오면,")
        class Context_Input_Not_1_Between_45 {

            private final int minimumLottoNumber = 0;
            private final int maximumLottoNumber = 46;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Create_Success() {
                assertThatThrownBy(() -> new LottoNumber(minimumLottoNumber)).isInstanceOf(
                    IllegalArgumentException.class);
                assertThatThrownBy(() -> new LottoNumber(maximumLottoNumber)).isInstanceOf(
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

            private final LottoNumber lottoNumber = new LottoNumber(1);
            private final LottoNumber sameLottoNumber = new LottoNumber(1);

            @Test
            @DisplayName("true를 반환한다")
            void It_Return_True() {
                assertThat(lottoNumber).isEqualTo(sameLottoNumber);
            }

        }
    }

}
