package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.InvalidLottoTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
    }

    @ParameterizedTest(name = "{index} {0} iss invalid number of numbers")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5"})
    void of_InvalidCountOfNumbers(String input) {
        assertThatThrownBy(() -> LottoTicket.of(input))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("반복된 숫자가 있으면 InvalidLottoTicketException 예외를 throw 한다.")
    void of_InvalidRepeatedNumbers() {
        assertThatThrownBy(() -> LottoTicket.of("1, 1, 3, 4, 5, 6"))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @ParameterizedTest(name = "{index} 번호 {0} 이/가 로또에 포함되어 있다 = {1}.")
    @CsvSource({"6,true", "8,false"})
    void contains_number(int number, boolean expected) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoTicket.contains(lottoNumber)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} Count of matches with {0} is equal to {1}.")
    @MethodSource
    void countOfMatches(String input, int expected) {
        LottoTicket otherTicket = LottoTicket.of(input);
        int actual = lottoTicket.countMatches(otherTicket);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> countOfMatches() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", 6),
                Arguments.of("1, 2, 3, 4, 5, 7", 5),
                Arguments.of("1, 2, 3, 4, 7, 8", 4),
                Arguments.of("1, 2, 3, 7, 8, 9", 3),
                Arguments.of("1, 2, 9, 10, 11, 12", 2),
                Arguments.of("7, 8, 9, 10, 11, 12", 0)
        );
    }
}
