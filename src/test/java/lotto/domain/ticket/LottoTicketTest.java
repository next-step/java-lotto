package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @DisplayName("LottoTicket 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
        assertThatCode(() -> LottoTicket.of("1, 2, 3, 4, 5, 6"))
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoTicket 생성 실패: 로또 슷자의 개수가 6개가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void notMetNumberCountCondition(final List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(numbers));
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(-1, 0, 3, 4, 5, 6))
        );
    }

    @DisplayName("LottoTicket 생성 실패: 1 ~ 45 이외의 숫자가 포함된 경우 예외 발생")
    @Test
    void outOfRangeLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(-1, 0, 3, 4, 5, 6)));
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수를 반환")
    @ParameterizedTest
    @MethodSource("purchasedTicketCase")
    void matchedCount(final LottoTicket ticket, final int expected) {
        final WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1, 2, 3, 4, 5, 6");
        assertThat(ticket.matchedCount(winningLottoTicket)).isEqualTo(expected);
    }

    private static Stream<Arguments> purchasedTicketCase() {
        return Stream.of(
                Arguments.of(LottoTicket.of(Arrays.asList(7, 8, 9, 10, 11, 12)), 0),
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 7, 8, 9)), 3),
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 7, 8)), 4),
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6)
        );
    }

    @DisplayName("특정 숫자가 티켓에 포함되어 있으면 true 를 반환")
    @ParameterizedTest
    @CsvSource({ "1,true", "7,false" })
    void contains(int number, final boolean expected) {
        final LottoTicket ticket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        assertThat(ticket.contains(LottoNumber.of(number)))
                .isEqualTo(expected);
    }
}
