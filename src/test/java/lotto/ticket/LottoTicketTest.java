package lotto.ticket;

import lotto.number.BonusNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓은 ")
class LottoTicketTest {

    private final int[] LOTTO_NUMBERS_EXAMPLE = {10, 11, 12, 13, 14, 15};
    private final int[] WINNING_NUMBERS = {1, 2, 3, 4, 5, 6};

    @DisplayName("로또 티켓은 6개의 숫자로 초기화된다.")
    @Test
    void createLottoTicket() {
        assertThat(new LottoTicket(LOTTO_NUMBERS_EXAMPLE).lottoNumbers().size()).isEqualTo(LottoNumbers.NUMBERS_LENGTH);
    }

    @DisplayName("당첨 번호에 따라, 티켓의 당첨금을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicketWithItsPrize")
    void lottoTicketKnowsItsPrize(LottoTicket lottoTicket, int bonusNumber, Prize prize) {
        WinningNumbers winningNumbers = new WinningNumbers(WINNING_NUMBERS);
        assertThat(lottoTicket.prize(winningNumbers, new BonusNumber(bonusNumber))).isEqualTo(prize);
    }

    private static Stream<Arguments> provideLottoTicketWithItsPrize() {
        return Stream.of(
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 6), 30, Prize.FIRST),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 45), 45, Prize.SECOND),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 5, 7), 30, Prize.THIRD),
                Arguments.of(new LottoTicket(1, 2, 3, 4, 8, 7), 30, Prize.FOURTH),
                Arguments.of(new LottoTicket(1, 2, 3, 9, 8, 7), 30, Prize.FIFTH),
                Arguments.of(new LottoTicket(1, 2, 10, 9, 8, 7), 30, Prize.LOSER),
                Arguments.of(new LottoTicket(1, 11, 10, 9, 8, 7), 30, Prize.LOSER),
                Arguments.of(new LottoTicket(12, 11, 10, 9, 8, 7), 30, Prize.LOSER)
        );
    }
}
