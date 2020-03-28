package LottoTests;

import lotto.model.LottoPurchaseTickets;
import lotto.model.LottoStore;
import lotto.model.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoStore 테스트")
public class LottoStoreTests {

    @DisplayName("로또 판매 테스트")
    @ParameterizedTest
    @MethodSource("sellTestCases")
    public void sellTest(Payment payment, Integer expectedLottoTicketsSize) {
        LottoPurchaseTickets lottoPurchaseTickets = LottoStore.sell(payment);
        assertThat(lottoPurchaseTickets.size()).isEqualTo(expectedLottoTicketsSize);
    }

    private static Stream<Arguments> sellTestCases() {
        return Stream.of(
                Arguments.of(Payment.newInstance(10000), 10),
                Arguments.of(Payment.newInstance(54321), 54),
                Arguments.of(Payment.newInstance(912), 0),
                Arguments.of(Payment.newInstance(0), 0));
    }

}
