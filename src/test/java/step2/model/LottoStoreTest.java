package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.model.LottoStore;
import lotto.model.Payment;
import lotto.model.PurchasedLottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStoreTest {

    @DisplayName("로또 판매 테스트")
    @ParameterizedTest
    @MethodSource("sellTestCases")
    public void sellTest(Payment payment, Integer expectedLottoTicketsCount) {
        PurchasedLottoTickets purchasedLottoTickets = LottoStore.sell(payment);
        assertThat(purchasedLottoTickets.count()).isEqualTo(expectedLottoTicketsCount);
    }

    private static Stream<Arguments> sellTestCases() {
        return Stream.of(
            Arguments.of(Payment.of(10000, 1), 9),
            Arguments.of(Payment.of(4321, 1), 3),
            Arguments.of(Payment.of(1000, 0), 1));
    }
}