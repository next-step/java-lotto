package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {10100, 1200, 2200})
    @DisplayName("총 로또 구매 가격 / 로또 장당 가격이 나누어 떨어지지 않을 때 예외가 발생한다.")
    void throwExceptionWhenTotalPriceNotDivisibleByTicketPrice(int totalPurchasePrice) {
        assertThatThrownBy(() -> Lotto.issueTickets(totalPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
    }

}
