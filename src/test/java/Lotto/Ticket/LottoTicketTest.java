package Lotto.Ticket;

import Lotto.Helper.Helper;
import Lotto.Number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 티켓은 ")
public class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 숫자로 초기화된다.")
    @Test
    void createLottoTicket() {
        assertDoesNotThrow(() -> new LottoTicket(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList())));
    }

    private static Stream<Arguments> provideLottoTicketWithItsPrize() {
        return Stream.of(
                Arguments.of(Helper.lottoTicket(0), Prize.FIRST),
                Arguments.of(Helper.lottoTicket(1), Prize.SECOND),
                Arguments.of(Helper.lottoTicket(2), Prize.THIRD),
                Arguments.of(Helper.lottoTicket(3), Prize.FOURTH),
                Arguments.of(Helper.lottoTicket(4), Prize.LOSER)
        );
    }

    @DisplayName("당첨금을 말한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicketWithItsPrize")
    void lottoTicketKnowsItsPrize(LottoTicket lottoTicket, Prize prize) {
        assertThat(lottoTicket.getPrize(Helper.winningNumbers())).isEqualTo(prize);
    }
}
