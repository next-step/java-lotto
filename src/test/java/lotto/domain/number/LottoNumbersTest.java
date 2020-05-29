package lotto.domain.number;

import lotto.domain.ticket.WinningLottoTicket;
import lotto.util.LottoNumbersGenerator;
import lotto.util.WinningLottoTicketGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        this.lottoNumbers = LottoNumbersGenerator.valueOf(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("LottoNumbers 생성")
    @Test
    void create() {
        assertThatCode(() -> LottoNumbers.manualCreate(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
        assertThatCode(LottoNumbers::autoCreate)
                .doesNotThrowAnyException();
    }

    @DisplayName("LottoNumbers 생성 실패: 로또 슷자의 개수가 6개가 아닌 경우 예외 발생")
    @ParameterizedTest
    @MethodSource("lottoNumbersCase")
    void notMetNumberCountCondition(final List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.manualCreate(numbers));
    }

    private static Stream<Arguments> lottoNumbersCase() {
        return Stream.of(
                Arguments.of(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5)),
                Arguments.of(LottoNumbersGenerator.toLottoNumberList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("LottoNumbers 생성 실패: 1 ~ 45 이외의 숫자가 포함된 경우 예외 발생")
    @Test
    void outOfRangeLottoNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersGenerator.valueOf(-1, 0, 3, 4, 5, 6));
    }

    @DisplayName("LottoNumbers 생성 실패: 중복된 숫자가 포함된 경우 예외 발생")
    @Test
    void duplicatedNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbersGenerator.valueOf(1, 1, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 개수를 반환")
    @ParameterizedTest
    @MethodSource("purchasedTicketCase")
    void matchedCount(final LottoNumbers ticket, final int expected) {
        final WinningLottoTicket winningLottoTicket =
                WinningLottoTicketGenerator.valueOf(7, 1, 2, 3, 4, 5, 6);

        assertThat(ticket.matchCount(winningLottoTicket)).isEqualTo(expected);
    }

    private static Stream<Arguments> purchasedTicketCase() {
        return Stream.of(
                Arguments.of(LottoNumbersGenerator.valueOf(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(LottoNumbersGenerator.valueOf(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(LottoNumbersGenerator.valueOf(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(LottoNumbersGenerator.valueOf(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(LottoNumbersGenerator.valueOf(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @DisplayName("특정 숫자가 티켓에 포함되어 있으면 true 를 반환")
    @ParameterizedTest
    @CsvSource({ "1,true", "7,false" })
    void contains(int number, final boolean expected) {
        assertThat(lottoNumbers.contains(LottoNumber.of(number)))
                .isEqualTo(expected);
    }

    @DisplayName("Set<LottoNumber>의 값을 List<Integer> 로 반환")
    @Test
    void getNumbersAsInt() {
        List<Integer> target = lottoNumbers.getNumbers();
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(target).isEqualTo(expected);
    }
}
