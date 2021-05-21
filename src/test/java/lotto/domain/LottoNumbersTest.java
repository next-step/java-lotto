package lotto.domain;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("provideListForNotValidLength")
    @DisplayName("6자리가 아닐 경우 예외가 발생한다")
    void lottoNumbersLengthExceptionTest(List<Integer> lottoNumbers) {
        assertThatThrownByCreateLottoTickets(lottoNumbers);
    }

    @ParameterizedTest
    @MethodSource("provideListForValidLottoNotDuplicate")
    @DisplayName("번호가 중복될 경우 예외가 발생한다")
    void validateLottoNumberNotDuplicateTest(List<Integer> lottoNumbers) {
        assertThatThrownByCreateLottoTickets(lottoNumbers);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,7,8,9:3", "1,2,3,4,7,8:4", "1,2,3,4,5,7:5", "1,2,3,4,5,6:6"}, delimiter = ':')
    @DisplayName("로또 번호와 당첨 번호의 일치하는 숫자를 구한다")
    void ticketMatchTest(String numbers, int expected) {
        LottoNumbers winningNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoTicket = LottoNumbers.of(StringUtils.toIntegerList(numbers));
        Prize prize = lottoTicket.match(winningNumbers);
        assertThat(prize).isEqualTo(Prize.findByMatchCount(expected));
    }

    private void assertThatThrownByCreateLottoTickets(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.of(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideListForValidLottoNotDuplicate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5))
        );
    }

    private static Stream<Arguments> provideListForNotValidLength() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

}