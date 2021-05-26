package lotto.domains;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.InvalidPatternException;
import lotto.exceptions.NumberOutOfBoundsException;

public class TicketTest {

    @DisplayName("티켓 생성을 생성한다.")
    @ParameterizedTest(name = "입력: \"{0}\", 출력: \"{1}\"")
    @CsvSource(value = {
        "1,2,3,4,5,6:[1, 2, 3, 4, 5, 6]",
        "45,44,43,42,41,40:[40, 41, 42, 43, 44, 45]"
    }, delimiter = ':')
    void createTicket(String input, String expected) {
        Ticket ticket = new Ticket(input);
        assertThat(ticket.toString()).isEqualTo(expected);
    }

    @DisplayName("잘못된 입력으로 티켓 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"", "a"})
    void createTicket_InvalidPattern_ExceptionThrown(String input) {
        assertThatExceptionOfType(InvalidPatternException.class).isThrownBy(() -> {
            new Ticket(input);
        });
    }

    @DisplayName("숫자 6개가 아니면 티켓 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void createTicket_Not6_ExceptionThrown(String input) {
        assertThatExceptionOfType(InsufficientNumbersException.class).isThrownBy(() -> {
            new Ticket(input);
        });
    }

    @DisplayName("1 ~ 45를 벗어난 숫자를 입력하여 티켓 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,99"})
    void createTicket_NumberOutOfBounds_ExceptionThrown(String input) {
        assertThatExceptionOfType(NumberOutOfBoundsException.class).isThrownBy(() -> {
            new Ticket(input);
        });
    }

    @DisplayName("중복된 숫자를 입력하여 티켓 생성을 실패한다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @ValueSource(strings = {"1,2,2,3,4,5"})
    void createTicket_OutOfBoundNumber_ExceptionThrown(String input) {
        assertThatExceptionOfType(DuplicateNumbersException.class).isThrownBy(() -> {
            new Ticket(input);
        });
    }

    @DisplayName("같은 숫자를 가지고 있다.")
    @ParameterizedTest(name = "입력: \"{0}\"")
    @CsvSource(value = {"1,2,3,4,5,6:1"}, delimiter = ':')
    void contains(String input, int element) {
        Ticket ticket = new Ticket(input);
        assertThat(ticket.contains(element)).isTrue();
    }

    private static Stream<Arguments> countSameNumbers() {
        return Stream.of(
            Arguments.of("1,2,3,4,5,6", 6),
            Arguments.of("1,2,3,4,5,36", 5),
            Arguments.of("1,2,3,4,35,36", 4),
            Arguments.of("1,2,3,34,35,36", 3),
            Arguments.of("1,2,33,34,35,36", 2),
            Arguments.of("1,32,33,34,35,36", 1),
            Arguments.of("31,32,33,34,35,36", 0)
        );
    }

    @DisplayName("두 티켓의 같은 숫자를 비교한다.")
    @ParameterizedTest(name = "\"1,2,3,4,5,6\"와 \"{0}\"는 \"{1}\"개 같음.")
    @MethodSource
    void countSameNumbers(String input, int expected) {
        Ticket ticket = new Ticket("1,2,3,4,5,6");
        Ticket other = new Ticket(input);
        assertThat(ticket.countSameNumbers(other)).isEqualTo(expected);
    }

}
