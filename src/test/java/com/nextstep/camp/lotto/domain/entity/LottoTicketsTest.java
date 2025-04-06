package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.exception.LottoTicketsCannotBeEmptyException;
import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketsTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("matchTestCases")
    void matchAll_should_return_correct_rank_list(List<List<Integer>> tickets, List<Integer> winning, int bonus, List<Rank> expectedRanks) {
        List<LottoTicket> ticketObjects = tickets.stream()
                .map(LottoTicket::of)
                .collect(Collectors.toList());

        LottoTickets lottoTickets = LottoTickets.of(ticketObjects);
        LottoNumbers lottoNumbers = LottoNumbers.of(winning);
        LottoNumber bonusNumber = LottoNumber.of(bonus);
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, bonusNumber);

        List<Rank> actualRanks = lottoTickets.matchAll(winningNumbers);
        assertEquals(expectedRanks, actualRanks);
    }

    static Stream<Arguments> matchTestCases() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 7),
                                List.of(1, 2, 3, 4, 5, 10),
                                List.of(1, 2, 3, 4, 10, 11),
                                List.of(1, 2, 3, 10, 11, 12),
                                List.of(1, 2, 10, 11, 12, 13)
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                Rank.SIX,
                                Rank.FIVE_BONUS,
                                Rank.FIVE,
                                Rank.FOUR,
                                Rank.THREE,
                                Rank.NONE
                        )
                )
        );
    }

    @Test
    void size_should_return_number_of_tickets() {
        List<LottoTicket> tickets = List.of(
                LottoTicket.of(List.of(1, 2, 3, 4, 5, 6)),
                LottoTicket.of(List.of(11, 12, 13, 14, 15, 16))
        );
        LottoTickets lottoTickets = LottoTickets.of(tickets);
        assertEquals(2, lottoTickets.size());
    }

    @Test
    void getTickets_should_return_original_ticket_list() {
        List<LottoTicket> original = List.of(
                LottoTicket.of(List.of(1, 2, 3, 4, 5, 6))
        );
        LottoTickets lottoTickets = LottoTickets.of(original);
        assertEquals(original, lottoTickets.getTickets());
    }
}
