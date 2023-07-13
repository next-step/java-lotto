package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import lottogame.domain.spi.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RandomNumberGenerator 클래스")
class LottoPurchaseManagerTest {

    @Nested
    @DisplayName("purchase 메소드는")
    class Describe_Buy {

        @Nested
        @DisplayName("1000원으로 나누어 떨어지지 않으면,")
        class Context_Not_Divided_By_1000 {

            private static final int NOT_DIVIDED_MONEY = 1001;

            private final NumberGenerator stubNumberGenerator = (count) -> Set.of(1, 2, 3, 4, 5, 6);
            private final LottoPurchaseManager lottoPurchaseManager = new LottoPurchaseManager(stubNumberGenerator);

            @Test
            @DisplayName("IllegalArgumentException 을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> lottoPurchaseManager.purchase(NOT_DIVIDED_MONEY)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }
    }
}
