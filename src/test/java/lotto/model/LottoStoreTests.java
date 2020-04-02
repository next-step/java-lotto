package lotto.model;

import lotto.model.wrapper.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoStore 테스트")
public class LottoStoreTests {

    @DisplayName("로또 판매 테스트 - 자동만")
    @ParameterizedTest
    @MethodSource("sellTestCases")
    public void sellTest(Payment payment, int expectedLottoTicketsSize) {
        LottoTickets lottoTickets = LottoStore.sell(payment);
        assertThat(lottoTickets.size()).isEqualTo(expectedLottoTicketsSize);
    }

    @DisplayName("로또 판매 테스트 - 수동 포함")
    @ParameterizedTest
    @MethodSource("sellWithManualLottoTestCases")
    public void sellTest(Payment payment, LottoTickets manualLottoTickets, int expectedLottoTicketsSize) {
        LottoTickets lottoTickets = LottoStore.sell(payment, manualLottoTickets);
        assertThat(lottoTickets.size()).isEqualTo(expectedLottoTicketsSize);
    }

    private static Stream<Arguments> sellTestCases() {
        return Stream.of(
                Arguments.of(Payment.of(10000), 10),
                Arguments.of(Payment.of(54321), 54),
                Arguments.of(Payment.of(912), 0),
                Arguments.of(Payment.of(0), 0));
    }


    private static Stream<Arguments> sellWithManualLottoTestCases() {
        return Stream.of(
                Arguments.of(Payment.of(5000),
                        LottoTickets.newInstance(
                                LottoTicket.newInstance(1, 2, 3, 4, 5, 6),
                                LottoTicket.newInstance(45, 7, 12, 10, 1, 5)),
                        5),
                Arguments.of(Payment.of(912),
                        LottoTickets.newInstance(null),
                        0),
                Arguments.of(Payment.of(1987),
                        LottoTickets.newInstance(Collections.EMPTY_SET),
                        0),
                Arguments.of(Payment.of(0),
                        LottoTickets.newInstance(
                                LottoTicket.newInstance(1, 2, 3, 4, 5, 6)),
                        5)
                ));
    }

}
