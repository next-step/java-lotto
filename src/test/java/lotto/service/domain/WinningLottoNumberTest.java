package lotto.service.domain;

import lotto.service.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumberTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호에 포함된 로또번호 갯수 체크 검증")
    void getMatchingCount(WinningLottoNumber winningLottoNumber, LottoTicket myLottoTicket, Integer expected) {
        // when
        Integer matchingCount = winningLottoNumber.getMatchingCount(myLottoTicket);

        // then
        assertThat(matchingCount).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("보너스번호 포함 여부 체크 검증")
    void isBonusNumberMatch(WinningLottoNumber winningLottoNumber, LottoTicket myLottoTicket, boolean expected) {
        // when
        boolean bonusNumberMatch = winningLottoNumber.isBonusNumberMatch(myLottoTicket);

        // then
        assertThat(bonusNumberMatch).isEqualTo(expected);
    }

    private static Stream<Arguments> getMatchingCount() {
        // given
        return Stream.of(
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 2, 3, 4, 5, 6), 5),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 3, 4, 5, 6), 4),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 4, 5, 6), 3),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 14, 5, 6), 2),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 14, 15, 6), 1),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 14, 15, 16), 0)
        );
    }

    private static Stream<Arguments> isBonusNumberMatch() {
        // given
        return Stream.of(
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(1, 2, 3, 4, 5, 7), true),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 2, 3, 4, 5, 7), true),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 3, 4, 5, 7), true),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 4, 5, 6), false),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 14, 5, 6), false),
                Arguments.of(getTestWinningLottoNumber(), getTestLottoTicket(11, 12, 13, 14, 15, 6), false)
        );
    }

    private static WinningLottoNumber getTestWinningLottoNumber() {
        return WinningLottoNumber.of(
                Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                              LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)), LottoNumber.from(7));
    }

    private static LottoTicket getTestLottoTicket(Integer number1, Integer number2, Integer number3, Integer number4,
                                                  Integer number5, Integer number6) {
        return LottoTicket.from(
                Arrays.asList(LottoNumber.from(number1), LottoNumber.from(number2), LottoNumber.from(number3),
                              LottoNumber.from(number4), LottoNumber.from(number5), LottoNumber.from(number6)));
    }
}
