package lotto.domain.ticket;

import lotto.domain.number.LottoNumbers;
import lotto.domain.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @DisplayName("LottoNumbers 를 인자로 받아 LottoTicket 생성")
    @Test
    void create() {
        LottoNumbers lottoNumbers = LottoNumbers.manualCreate("1, 2, 3, 4, 5, 6");
        assertThatCode(() -> LottoTicket.of(lottoNumbers))
            .doesNotThrowAnyException();
    }

    @DisplayName("LottoNumbers 가 null 이면 예외를 반환")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(null));
    }

    @DisplayName("우승 티켓과 일치하는 상금을 반환")
    @ParameterizedTest
    @MethodSource
    void matchPrize(final LottoTicket ticket, final Prize expected) {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.valueOf("1, 2, 3, 4, 5, 6", 7);
        assertThat(ticket.matchPrize(winningLottoTicket)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchPrize() {
        return Stream.of(
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 4, 5, 6")), Prize.FIRST),
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 4, 5, 7")), Prize.SECOND),
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 4, 5, 8")), Prize.THIRD),
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 4, 7, 8")), Prize.FOURTH),
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 7, 8, 9")), Prize.FIFTH),
                Arguments.of(LottoTicket.of(LottoNumbers.manualCreate("7, 8, 9, 10, 11, 12")), Prize.MISS)
        );
    }

    @DisplayName("LottoNumbers 의 값을 List<Integer> 로 반환")
    @Test
    void getLottoNumbersAsInt() {
        final LottoTicket ticket = LottoTicket.of(LottoNumbers.manualCreate("1, 2, 3, 4, 5, 6"));
        List<Integer> target = ticket.getLottoNumbersAsInt();

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(target).isEqualTo(expected);
    }
}
