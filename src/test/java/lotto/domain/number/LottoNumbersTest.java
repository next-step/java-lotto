package lotto.domain.number;

import lotto.domain.ticket.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @DisplayName("LottoNumbers 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoNumbers.of("1, 2, 3, 4, 5, 6"))
                .doesNotThrowAnyException();
        assertThatCode(() -> LottoNumbers.of("1, 2, 3, 4, 5, 6"))
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoNumbers 생성 실패: 로또 슷자의 개수가 6개가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void notMetNumberCountCondition(final String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(numbers));
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5"),
                Arguments.of("1, 2, 3, 4, 5, 6, 7"),
                Arguments.of("-1, 0, 3, 4, 5, 6")
        );
    }

    @DisplayName("LottoNumbers 생성 실패: 1 ~ 45 이외의 숫자가 포함된 경우 예외 발생")
    @Test
    void outOfRangeLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of("-1, 0, 3, 4, 5, 6"));
    }

    @DisplayName("LottoNumbers 생성 실패: 중복된 숫자가 포함된 경우 예외 발생")
    @Test
    void duplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of("1, 1, 3, 4, 5, 6"));
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수를 반환")
    @ParameterizedTest
    @MethodSource("purchasedTicketCase")
    void matchedCount(final LottoNumbers ticket, final int expected) {
        final WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1, 2, 3, 4, 5, 6");
        assertThat(ticket.matchCount(winningLottoTicket)).isEqualTo(expected);
    }

    private static Stream<Arguments> purchasedTicketCase() {
        return Stream.of(
                Arguments.of(LottoNumbers.of("7, 8, 9, 10, 11, 12"), 0),
                Arguments.of(LottoNumbers.of("1, 2, 3, 7, 8, 9"), 3),
                Arguments.of(LottoNumbers.of("1, 2, 3, 4, 7, 8"), 4),
                Arguments.of(LottoNumbers.of("1, 2, 3, 4, 5, 7"), 5),
                Arguments.of(LottoNumbers.of("1, 2, 3, 4, 5, 6"), 6)
        );
    }

    @DisplayName("특정 숫자가 티켓에 포함되어 있으면 true 를 반환")
    @ParameterizedTest
    @CsvSource({ "1,true", "7,false" })
    void contains(int number, final boolean expected) {
        final LottoNumbers ticket = LottoNumbers.of("1, 2, 3, 4, 5, 6");
        assertThat(ticket.contains(LottoNumber.of(number)))
                .isEqualTo(expected);
    }
}
