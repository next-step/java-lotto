package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("티켓구매 - 유효하지 않은 구매숫자")
    void invalidPurchaseCount(int purchaseCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.autoTickets(purchaseCount))
                .withMessageMatching("구매 수량을 입력해 주세요.");
    }
}