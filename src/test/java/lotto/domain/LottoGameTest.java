package lotto.domain;

import lotto.domain.number.LottoNumbers;
import lotto.domain.price.Price;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.prize.Prize;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.util.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.of(LottoNumbers.manualCreate(Generator.lottoNumberList(1, 2, 3, 4, 5, 6))));
        tickets.add(LottoTicket.of(LottoNumbers.manualCreate(Generator.lottoNumberList(1, 2, 3, 4, 5, 7))));
        tickets.add(LottoTicket.of(LottoNumbers.manualCreate(Generator.lottoNumberList(1, 2, 3, 7, 8, 9))));
        tickets.add(LottoTicket.of(LottoNumbers.manualCreate(Generator.lottoNumberList(1, 2, 3, 7, 8, 9))));
        tickets.add(LottoTicket.of(LottoNumbers.manualCreate(Generator.lottoNumberList(7, 8, 9, 10, 11, 12))));

        lottoTickets = LottoTickets.of(tickets);
    }

    @DisplayName("LottoGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoGame.of(Price.of(Price.ONE_TICKET_PRICE), lottoTickets))
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoGame 생성 실패: 인자 중 하나라도 null 인 경우")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGame.of(null, lottoTickets));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGame.of(Price.of(Price.ONE_TICKET_PRICE), null));
    }

    @DisplayName("생성 -> play -> LottoPrizeResult 의 당첨 개수로 비교")
    @ParameterizedTest
    @MethodSource("getMatchedTicketCountCase")
    void play(final Prize prize, final int count) {
        final WinningLottoTicket winningLottoTicket =
                WinningLottoTicket.valueOf(Generator.lottoNumberList(1, 2, 3, 4, 5, 6), 7);
        LottoPrizeResult lottoPrizeResult = LottoGame.of(Price.of(Price.ONE_TICKET_PRICE * 5), lottoTickets)
                .play(winningLottoTicket);

        assertThat(lottoPrizeResult.getMatchedTicketCount(prize)).isEqualTo(count);
    }

    private static Stream<Arguments> getMatchedTicketCountCase() {
        return Stream.of(
                Arguments.of(Prize.MISS, 1),
                Arguments.of(Prize.FIFTH, 2),
                Arguments.of(Prize.FOURTH, 0),
                Arguments.of(Prize.THIRD, 0),
                Arguments.of(Prize.SECOND, 1),
                Arguments.of(Prize.FIRST, 1)
        );
    }
}
