package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
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

public class WinningLottoTicketTest {

    @DisplayName("WinningLottoTicket 생성")
    @Test
    void create() {
        assertThatCode(() -> WinningLottoTicket.of("1, 2, 3, 4, 5, 6"))
                .doesNotThrowAnyException();
    }

    @DisplayName("WinningLottoTicket 생성 실패: 로또 슷자의 개수가 6개가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void notMetNumberCountCondition(final List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(numbers));
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(-1, 0, 3, 4, 5, 6))
        );
    }

    @DisplayName("WinningLottoTicket 생성 실패: 1 ~ 45 이외의 숫자가 포함된 경우 예외 발생")
    @Test
    void outOfRangeLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(Arrays.asList(-1, 0, 3, 4, 5, 6)));
    }

    @DisplayName("특정 숫자가 티켓에 포함되어 있으면 true 를 반환")
    @ParameterizedTest
    @CsvSource({ "1,true", "7,false" })
    void contains(int number, final boolean expected) {
        final WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1, 2, 3, 4, 5, 6");
        assertThat(winningLottoTicket.contains(LottoNumber.of(number)))
                .isEqualTo(expected);
    }
}
