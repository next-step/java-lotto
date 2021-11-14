package lotto.service.domain;

import lotto.service.domain.types.Rank;
import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTicketTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호에 포함된 로또번호 갯수 체크 검증")
    void matchRank(WinningLottoTicket winningLottoTicket, LottoTicket myLottoTicket, Rank expected) {
        Rank rank = winningLottoTicket.matchRank(myLottoTicket);
        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> matchRank() {
        // given
        return Stream.of(
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 4, 15, 16), Rank.FOURTH),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 4, 15, 7), Rank.FOURTH),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 14, 15, 17), Rank.FIFTH),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 3, 14, 15, 7), Rank.FIFTH),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 2, 13, 14, 15, 7), Rank.MISS),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(1, 12, 13, 14, 15, 7), Rank.MISS),
                Arguments.of(getTestWinningLottoTicket(), getTestLottoTicket(11, 12, 13, 14, 15, 7), Rank.MISS)
        );
    }

    private static WinningLottoTicket getTestWinningLottoTicket() {
        return WinningLottoTicket.of(
                Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)), 7);
    }

    private static LottoTicket getTestLottoTicket(Integer number1, Integer number2, Integer number3, Integer number4,
                                                  Integer number5, Integer number6) {
        return LottoTicket.from(
                Arrays.asList(LottoNumber.from(number1), LottoNumber.from(number2), LottoNumber.from(number3),
                              LottoNumber.from(number4), LottoNumber.from(number5), LottoNumber.from(number6)));
    }
}
