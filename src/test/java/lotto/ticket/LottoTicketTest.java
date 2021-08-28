package lotto.ticket;

import lotto.helper.Helper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓은 ")
class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 숫자로 초기화된다.")
    @Test
    void createLottoTicket() {
        assertThat(Helper.lottoTicket(1, 2, 3, 4, 5, 6).getValue().size()).isEqualTo(6);
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

    @DisplayName("당첨 번호에 따라, 티켓의 당첨금을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicketWithItsPrize")
    void lottoTicketKnowsItsPrize(LottoTicket lottoTicket, Prize prize) {
        assertThat(lottoTicket.getPrize(Helper.winningNumbers())).isEqualTo(prize);
    }
}
