package lotto.domain;

import lotto.generic.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoGameTest {

    @DisplayName("로또 티켓 구매")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void buy(int purchaseAmount, String[] inputManualTickets) {
        Money amount = Money.wons(purchaseAmount);
        int expectedTicketCount = amount.divideAndDiscardRemainder(TicketCount.LOTTO_PRICE);
        LottoTickets lottoTickets = LottoGame.buy(amount, inputManualTickets);

        assertAll(
                () -> assertThat(lottoTickets.getLottoTickets()).hasSize(expectedTicketCount),
                () -> assertThat(lottoTickets.getAutoTicketCount()).isEqualTo(expectedTicketCount - inputManualTickets.length)
        );
    }

    //구매금액, 수동 로또 배열
    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(14500, new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"}),
                Arguments.of(14500, new String[0]),
                Arguments.of(3000, new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"})
        );
    }
}
