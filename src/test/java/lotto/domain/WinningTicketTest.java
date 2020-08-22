package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTicketTest {

    private static Stream<Arguments> provideListForIsMatchBonusBall() {
        return Stream.of(
                Arguments.of(Arrays.asList(5, 9, 11, 21, 29, 35), false),
                Arguments.of(Arrays.asList(1, 2, 3, 40, 43, 45), true),
                Arguments.of(Arrays.asList(10, 17, 21, 28, 39, 40), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideListForIsMatchBonusBall")
    @DisplayName("로또 티켓에 보너스 번호가 있는지 확인")
    void isMatchBonusBall(List<Integer> numbers, boolean expected) {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 10, 15, 35);
        Integer bonusNumber = 40;
        WinningTicket winningTicket = WinningTicket.of(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = LottoTicket.of(numbers);

        // when
        boolean result = winningTicket.isMatchBonusBall(lottoTicket);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForGetRank() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 10, 11, 21, 29, 35), Rank.FIRST),
                Arguments.of(Arrays.asList(3, 10, 11, 21, 29, 38), Rank.SECOND),
                Arguments.of(Arrays.asList(3, 10, 17, 21, 29, 35), Rank.THIRD),
                Arguments.of(Arrays.asList(3, 10, 17, 21, 29, 38), Rank.FOURTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForGetRank")
    @DisplayName("로또 티켓의 당첨 순위 확인")
    void getRank(List<Integer> numbers, Rank expected) {
        // given
        List<Integer> winningNumbers = Arrays.asList(3, 10, 11, 21, 29, 35);
        Integer bonusNumber = 38;
        WinningTicket winningTicket = WinningTicket.of(winningNumbers, bonusNumber);
        LottoTicket lottoTicket = LottoTicket.of(numbers);

        // when
        Rank result = winningTicket.getRank(lottoTicket);

        // then
        assertThat(result).isEqualTo(expected);
    }


}