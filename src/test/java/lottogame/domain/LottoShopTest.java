package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;
import lottogame.service.request.LottoPurchaseRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoShop 클래스")
class LottoShopTest {

    @Nested
    @DisplayName("purchase 메소드는")
    class Describe_Buy {

        @Nested
        @DisplayName("1000원으로 나누어 떨어지지 않으면,")
        class Context_Not_Divided_By_1000 {

            private static final int NOT_DIVIDED_MONEY = 1001;

            private final LottoPurchaseRequest lottoPurchaseRequest = new LottoPurchaseRequest(NOT_DIVIDED_MONEY, 0, List.of());
            private final NumberGenerator stubNumberGenerator = (count) -> Set.of(1, 2, 3, 4, 5, 6);
            private final LottoShop lottoShop = new LottoShop();

            @Test
            @DisplayName("IllegalArgumentException 을 던진다")
            void It_Throw_IllegalArgumentException() {
                assertThatThrownBy(() -> lottoShop.purchase(lottoPurchaseRequest, stubNumberGenerator)).isInstanceOf(
                    IllegalArgumentException.class);
            }
        }
    }
}
