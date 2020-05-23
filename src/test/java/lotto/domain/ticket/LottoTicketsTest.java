package lotto.domain.ticket;

import lotto.domain.prize.Prize;
import lotto.util.LottoTicketGenerator;
import lotto.util.WinningLottoTicketGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    private List<LottoTicket> tickets;

    @BeforeEach
    void setUp() {
        tickets = new ArrayList<>();
        tickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 6));
        tickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 4, 5, 7));
        tickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));
        tickets.add(LottoTicketGenerator.valueOf(1, 2, 3, 7, 8, 9));
        tickets.add(LottoTicketGenerator.valueOf(7, 8, 9, 10, 11, 12));
    }

    @DisplayName("List<LottoTicket> 를 인자로 받아 LottoTickets 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoTickets.of(tickets))
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoNumbers List 가 null 이면 예외를 반환")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.of(null));
    }

    @DisplayName("구입한 모든 티켓의 우승 티켓과 일치하는 상금의 개수를 반환")
    @MethodSource
    @ParameterizedTest
    void matchPrizes(final Prize prize, final Long expected) {
        final WinningLottoTicket winningLottoTicket =
                WinningLottoTicketGenerator.valueOf(7, 1, 2, 3, 4, 5, 6);
        LottoTickets lottoTickets = LottoTickets.of(tickets);

        Map<Prize, Long> prizes = lottoTickets.matchPrizes(winningLottoTicket);

        assertThat(prizes.get(prize)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchPrizes() {
        return Stream.of(
                Arguments.of(Prize.FIRST, 1L),
                Arguments.of(Prize.SECOND, 1L),
                Arguments.of(Prize.THIRD, null),
                Arguments.of(Prize.FOURTH, null),
                Arguments.of(Prize.FIFTH, 2L),
                Arguments.of(Prize.MISS, 1L)
        );
    }

    @DisplayName("LottoTicket 의 개수 반환")
    @Test
    void count() {
        assertThat(LottoTickets.of(tickets).count()).isEqualTo(tickets.size());
    }

    @DisplayName("인자로 입력받은 LottoTickets 를 이어 붙인 LottoTickets 반환")
    @Test
    void merge() {
        LottoTickets originTickets = Generator.lottoTickets(Generator.lottoTicket(1, 2, 3, 4, 5, 6));

        assertThat(originTickets.merge(LottoTickets.of(tickets)).count())
                .isEqualTo(6);
    }
}
