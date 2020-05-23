package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.util.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTicketTest {

    @DisplayName("WinningLottoTicket 생성")
    @Test
    void create() {
        final List<LottoNumber> numbers = Generator.lottoNumberList(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> WinningLottoTicket.valueOf(numbers, 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("WinningLottoTicket 생성 실패: 로또 슷자의 개수가 6개가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void notMetNumberCountCondition(final List<LottoNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.manualCreate(numbers));
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of(Generator.lottoNumberList(1, 2, 3, 4, 5)),
                Arguments.of(Generator.lottoNumberList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("WinningLottoTicket 생성 실패: 1 ~ 45 이외의 숫자가 포함된 경우 예외 발생")
    @Test
    void outOfRangeLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Generator.lottoNumbers(-1, 0, 3, 4, 5, 6));
    }

    @DisplayName("특정 숫자가 티켓에 포함되어 있으면 true 를 반환")
    @ParameterizedTest
    @CsvSource({ "1,true", "7,false" })
    void contains(final int number, final boolean expected) {
        final WinningLottoTicket winningLottoTicket =
                WinningLottoTicket.valueOf(Generator.lottoNumberList(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLottoTicket.lottoNumbers.contains(LottoNumber.of(number)))
                .isEqualTo(expected);
    }

    @DisplayName("보너스 볼이 기존의 당첨 번호와 중복되면 예외 반환")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2 })
    void duplicatedBonusNumber(final int bonusNumber) {
        final List<LottoNumber> numbers = Generator.lottoNumberList(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException().isThrownBy(() ->
                WinningLottoTicket.valueOf(numbers, bonusNumber));
    }
}
