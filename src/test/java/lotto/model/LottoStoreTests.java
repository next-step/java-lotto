package lotto.model;

import lotto.model.wrapper.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoStore 테스트")
public class LottoStoreTests {

    @DisplayName("로또 판매 테스트")
    @ParameterizedTest
    @MethodSource("sellTestCases")
    public void sellTest(Payment payment, LottoTickets manualLottoTickets, int expectedLottoTicketsSize) {
        LottoTickets lottoTickets = LottoStore.sell(payment, manualLottoTickets);
        assertThat(lottoTickets.size()).isEqualTo(expectedLottoTicketsSize);
    }

    @DisplayName("로또 판매 테스트 - 돈이 부족함")
    @ParameterizedTest
    @MethodSource("sellShortMoneyTestCases")
    public void sellShortMoneyTest(Payment payment, LottoTickets manualLottoTickets) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoStore.sell(payment, manualLottoTickets))
                .withMessageContaining("입력 받은 수동 로또들을 전부 구입하기엔 돈이 모자릅니다.");
    }

    private static Stream<Arguments> sellTestCases() {
        return Stream.of(
                Arguments.of(Payment.of(1987),
                        LottoTickets.newInstance(Collections.EMPTY_LIST),
                        1),
                Arguments.of(Payment.of(5000),
                        LottoTickets.newInstance(
                                LottoTicket.newInstance(1, 2, 3, 4, 5, 6),
                                LottoTicket.newInstance(45, 7, 12, 10, 1, 5)),
                        5)
        );
    }

    private static Stream<Arguments> sellShortMoneyTestCases() {
        return Stream.of(
                Arguments.of(Payment.of(0),
                        LottoTickets.newInstance(
                                LottoTicket.newInstance(1, 2, 3, 4, 5, 6)))
        );
    }

}
