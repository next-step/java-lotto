package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTicketTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when & then
        assertThat(lottoWinningTicket).isEqualTo(new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @DisplayName("getWinningCondition() 테스트")
    @ParameterizedTest
    @MethodSource("provideTicketAndWiningCondition")
    void getWinningCondition(LottoTicket lottoTicket, WinningCondition expected) {
        // given
        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        WinningCondition winningCondition = lottoWinningTicket.getWinningCondition(lottoTicket.getLottoNumberList());

        // then
        assertThat(winningCondition).isEqualTo(expected);
    }

    /*
        당첨번호 1,2,3,4,5,6 + 7 에 대해
        1등 - WinningCondition(6, false)
        2등 - WinningCondition(5, true)
        3등 - WinningCondition(5, false)
        4등 - WinningCondition(4, false)
     */
    private static Stream<Arguments> provideTicketAndWiningCondition() {
        return Stream.of(
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))
                , new WinningCondition(6, false)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7))
                        , new WinningCondition(5, true)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45))
                        , new WinningCondition(5, false)),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 44, 45))
                        , new WinningCondition(4, false))
        );
    }
}
