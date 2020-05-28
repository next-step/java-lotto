package dev.dahye.lotto.domain;

import dev.dahye.lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 티켓")
class LottoTicketTest {
    @ParameterizedTest(name = "{0}원일 때, {1}개")
    @MethodSource("moneyForTicket")
    @DisplayName("로또 구입 금액을 입력하면 구입 금액 만큼 로또를 발급한다.")
    void 로또_발급(int money, int ticketCount) {
        LottoService lottoService = new LottoService(money);
        assertThat(ticketCount).isEqualTo(lottoService.getTotalCount());
    }

    private static Stream<Arguments> moneyForTicket() {
        return Stream.of(
                arguments(1000, 1),
                arguments(2000, 2),
                arguments(10000, 10)
        );
    }
}