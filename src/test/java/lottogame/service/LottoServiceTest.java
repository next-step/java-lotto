package lottogame.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import lottogame.domain.spi.NumberGenerator;
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

            private final NumberGenerator stubNumberGenerator = (count) -> Set.of(1, 2, 3, 4, 5, 6);
            private final LottoService lottoService = new LottoService(stubNumberGenerator);

            @Test
            @DisplayName("IllegalArgumentException 을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> lottoService.buy(1001)).isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
