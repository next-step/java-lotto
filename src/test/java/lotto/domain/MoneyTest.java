package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 999})
    void 구매_금액이_최소_주문금액_이하일때(int purchaseAmount) {
        final String MIN_MONEY_MESSAGE = "1000원 이상의 구매금액이 필요합니다.";

        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(MIN_MONEY_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 3050})
    void 구매_금액이_정상일때(int purchaseAmount) {
        assertThat(new PurchaseAmount(purchaseAmount).getPurchaseAmount()).isEqualTo(purchaseAmount);
    }
}
