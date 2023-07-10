package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    }
}
