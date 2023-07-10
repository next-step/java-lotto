package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoNumbers 클래스")
class LottoNumbersTest {

    @Nested
    @DisplayName("new 생성자는")
    class Describe_New_Constructor {

        @Nested
        @DisplayName("6개의 int값으로")
        class Context_Input_Six_Integer {

            private final List<Integer> lottoValues = List.of(1, 2, 3, 4, 5, 45);

            @Test
            @DisplayName("생성할 수 있다.")
            void It_Create_Success() {
                assertThatCode(() -> new LottoNumbers(lottoValues)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("6개의 int값이 아니면")
        class Context_Input_Non_Six_Integer {

            private final List<Integer> lessLottoValues = List.of(1, 2, 3, 4, 5);
            private final List<Integer> moreLottoValues = List.of(1, 2, 3, 4, 5, 6, 7);

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> new LottoNumbers(lessLottoValues)).isInstanceOf(
                    IllegalArgumentException.class);
                assertThatThrownBy(() -> new LottoNumbers(moreLottoValues)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("null 파라미터가 입력되면")
        class Context_Input_Null_Parameter {

            @ParameterizedTest
            @NullSource
            @DisplayName("IllegalArgumentException을 던진다.")
            void It_Throw_IllegalArgumentException(List<Integer> nullValue) {
                assertThatThrownBy(() -> new LottoNumbers(nullValue)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("equals는")
    class Describe_Equals {

        @Nested
        @DisplayName("같은 LottoNumbers 를 가지고 있으면,")
        class Context_Same_Lotto_Numbers {

            private final List<Integer> lottoValues = List.of(1, 2, 3, 4, 5, 45);
            private final LottoNumbers lottoNumbers = new LottoNumbers(lottoValues);
            private final LottoNumbers sameLottoNumbers = new LottoNumbers(lottoValues);

            @Test
            @DisplayName("논리적으로 동일하다")
            void It_Same_Objects() {
                assertThat(lottoNumbers).isEqualTo(sameLottoNumbers);
            }

        }

    }
}
