package lotto.domain.model;

import static lotto.domain.model.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    private LottoTicket winningTicket;
    private LottoTicket firstPrizeTicket;
    private LottoTicket thirdPrizeTicket;
    private LottoTicket fourthPrizeTicket;
    private LottoTicket fifthPrizeTicket;
    private LottoTicket noPrizeTicket;

    @BeforeEach
    void setUp() {
        winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        firstPrizeTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        thirdPrizeTicket = LottoTicket.of("1, 2, 3, 4, 5, 7");
        fourthPrizeTicket = LottoTicket.of("1, 2, 3, 4, 7, 8");
        fifthPrizeTicket = LottoTicket.of("1, 2, 3, 7, 8, 9");
        noPrizeTicket = LottoTicket.of("1, 2, 9, 10, 11, 12");
    }

    @Test
    void match_one_first_one_third() {
        LottoTickets lottoTickets = LottoTickets.of(
                Arrays.asList(firstPrizeTicket, thirdPrizeTicket));

        LottoResult expectedResults = LottoResult.empty();
        expectedResults.update(FIRST, 1);
        expectedResults.update(THIRD, 1);

        LottoResult actualResults = lottoTickets.match(winningTicket);
        assertThat(actualResults).isEqualTo(expectedResults);
    }

    @Test
    void match_two_fourth_one_fifth_one_miss() {
        LottoTickets lottoTickets = LottoTickets.of(
                Arrays.asList(fourthPrizeTicket, fifthPrizeTicket, noPrizeTicket,
                        fourthPrizeTicket));

        Map<LottoRank, Integer> rankToCount = Stream.of(new Object[][]{
                {FOURTH, 2},
                {FIFTH, 1},
                {MISS, 1}
        }).collect(Collectors.toMap(data -> (LottoRank) data[0], data -> (int) data[1]));
        LottoResult expected = LottoResult.of(rankToCount);

        LottoResult actual = lottoTickets.match(winningTicket);
        assertThat(actual).isEqualTo(expected);
    }
}
