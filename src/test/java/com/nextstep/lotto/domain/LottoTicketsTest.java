package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static com.nextstep.lotto.domain.LottoTicketFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @DisplayName("LottoTicket 컬렉션을 인자로 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<LottoTicket> lottoTickets = Arrays.asList(LOTTO_TICKET_123456, LOTTO_TICKET_234567);

        assertThat(new LottoTickets(lottoTickets)).isNotNull();
    }

    @DisplayName("당첨 LottoTicket을 인자로 전달해서 당첨 결과를 확인할 수 있다.")
    @ParameterizedTest
    @MethodSource("checkResultTestResource")
    void checkResultTest(WinningTicket winningTicket, LottoPrize expected) {
        List<LottoTicket> boughtTickets = Arrays.asList(LOTTO_TICKET_123456, LOTTO_TICKET_101112131415);
        LottoTickets lottoTickets = new LottoTickets(boughtTickets);

        assertThat(lottoTickets.checkResult(winningTicket)).isEqualTo(expected);
    }
    public static Stream<Arguments> checkResultTestResource() {
        return Stream.of(
                Arguments.of(
                        new WinningTicket(LOTTO_TICKET_123456, new LottoNumber(7)),
                        new LottoPrize(Arrays.asList(Rank.FIRST))
                ),
                Arguments.of(
                        new WinningTicket(LOTTO_TICKET_234567, new LottoNumber(1)),
                        new LottoPrize(Arrays.asList(Rank.SECOND))
                ),
                Arguments.of(
                        new WinningTicket(LOTTO_TICKET_234567, new LottoNumber(8)),
                        new LottoPrize(Arrays.asList(Rank.THIRD))
                )
        );
    }
}
