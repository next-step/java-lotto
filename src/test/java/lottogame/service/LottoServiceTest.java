package lottogame.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RandomNumberGenerator 클래스")
class LottoServiceTest {

    @Nested
    @DisplayName("buy 메소드는")
    class Describe_Buy {

        @Nested
        @DisplayName("1000원으로 나누어 떨어지지 않으면,")
        class Context_Not_Divided_By_1000 {

            @Test
            @DisplayName("IllegalArgumentException을 던진다")
            void It_Throw_IllegalArgumentException() {
                LottoService lottoService = new LottoService();

                assertThatThrownBy(() -> lottoService.buy(1001)).isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
