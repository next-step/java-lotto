package lotto.domain.prize;

import lotto.domain.Price;
import lotto.domain.number.LottoNumbers;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoPrizeResultTest {

    private List<LottoTicket> tickets = new ArrayList<>();
    private Map<Prize, Long> matchedPrizes;

    @BeforeEach
    void setUp() {
        tickets = new ArrayList<>();
        tickets.add(LottoTicket.of(LottoNumbers.of("1, 2, 3, 4, 5, 6")));
        tickets.add(LottoTicket.of(LottoNumbers.of("1, 2, 3, 4, 5, 7")));
        tickets.add(LottoTicket.of(LottoNumbers.of("1, 2, 3, 7, 8, 9")));
        tickets.add(LottoTicket.of(LottoNumbers.of("1, 2, 3, 7, 8, 9")));
        tickets.add(LottoTicket.of(LottoNumbers.of("7, 8, 9, 10, 11, 12")));

        final WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1, 2, 3, 4, 5, 6");
        matchedPrizes = LottoTickets.of(tickets).matchPrizes(winningLottoTicket);
    }

    @DisplayName("LottoPrizeResult 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoPrizeResult.init(Price.of(Price.ONE_TICKET_PRICE), matchedPrizes))
                .doesNotThrowAnyException();
    }

    @DisplayName("예상되는 일치하는 티켓 개수 비교 (getMatchedTicketCount)")
    @ParameterizedTest
    @MethodSource
    void getMatchedTicketCount(final Prize prize, final int count) {
        LottoPrizeResult lottoPrizeResult = LottoPrizeResult.init(
                Price.of(Price.ONE_TICKET_PRICE * tickets.size()), matchedPrizes);

        assertThat(lottoPrizeResult.getMatchedTicketCount(prize)).isEqualTo(count);
    }

    private static Stream<Arguments> getMatchedTicketCount() {
        return Stream.of(
                Arguments.of(Prize.MISS, 1),
                Arguments.of(Prize.FIFTH, 2),
                Arguments.of(Prize.FOURTH, 0),
                Arguments.of(Prize.THIRD, 1),
                Arguments.of(Prize.FIRST, 1)
        );
    }

    @DisplayName("예상되는 수익률 비교 (calculateProfitRate)")
    @Test
    void calculateProfitRate() {
        int purchasedPrice = Price.ONE_TICKET_PRICE * tickets.size();
        LottoPrizeResult lottoPrizeResult = LottoPrizeResult.init(Price.of(purchasedPrice), matchedPrizes);

        int expectedTotalPrizeMoney =
                Prize.FIRST.getPrizeMoney() + Prize.THIRD.getPrizeMoney() + Prize.FIFTH.getPrizeMoney() * 2;
        float expected = (float) expectedTotalPrizeMoney / purchasedPrice;

        assertThat(lottoPrizeResult.calculateProfitRate()).isEqualTo(expected);
    }
}
