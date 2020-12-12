package com.nextstep.lotto.domain;

import com.nextstep.lotto.domain.exceptions.InvalidWinningTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.nextstep.lotto.domain.LottoTicketFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTicketTest {
    @DisplayName("당첨 티켓과 보너스 넘버는 중복이 없어야 한다.")
    @ParameterizedTest
    @MethodSource("createFailTestResource")
    void createFailTest(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        assertThatThrownBy(() -> new WinningTicket(lottoTicket, bonusNumber))
                .isInstanceOf(InvalidWinningTicketException.class);

    }
    public static Stream<Arguments> createFailTestResource() {
        return Stream.of(
                Arguments.of(LOTTO_TICKET_123456, new LottoNumber(1)),
                Arguments.of(LOTTO_TICKET_123456, new LottoNumber(5))
        );
    }

    @DisplayName("로또 당첨 결과를 알려줄 수 있다.")
    @ParameterizedTest
    @MethodSource("calculateRankTestResource")
    void calculateRankTest(LottoTicket candidateTicket, Rank expected) {
        WinningTicket winningTicket = new WinningTicket(LOTTO_TICKET_123456, new LottoNumber(7));

        assertThat(winningTicket.calculateRank(candidateTicket)).isEqualTo(expected);
    }
    public static Stream<Arguments> calculateRankTestResource() {
        return Stream.of(
                Arguments.of(LOTTO_TICKET_123456, Rank.FIRST),
                Arguments.of(LOTTO_TICKET_234567, Rank.SECOND),
                Arguments.of(LOTTO_TICKET_234568, Rank.THIRD),
                Arguments.of(LOTTO_TICKET_345678, Rank.FOURTH),
                Arguments.of(LOTTO_TICKET_456789, Rank.FIFTH)
        );
    }
}
