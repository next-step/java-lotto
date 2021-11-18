package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lotto.exception.ArgumentCountException;
import lotto.exception.ArgumentNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

    static Stream<Arguments> generateTicketCountException() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5))),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 44, 45, 5)))
        );
    }

    static Stream<Arguments> generateTicketNumberException() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 46))),
            Arguments.of(new HashSet<>(Arrays.asList(0, 2, 3, 4, 44, 45)))
        );
    }

    @Test
    @DisplayName("티켓 객체 생성 성공")
    void create() {
        Set<Integer> args = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LottoTicket.of(args)).isEqualTo(LottoTicket.of(args));
    }

    @ParameterizedTest
    @DisplayName("번호 갯수가 6이 아닐 시 예외처리")
    @MethodSource("generateTicketCountException")
    void ticketCountException(Set<Integer> ticket) {
        assertThatExceptionOfType(ArgumentCountException.class)
            .isThrownBy(() -> LottoTicket.of(ticket));
    }

    @ParameterizedTest
    @DisplayName("번호가 1 ~ 45 사이가 아닐 시 예외처리")
    @MethodSource("generateTicketNumberException")
    void ticketNumberException(Set<Integer> ticket) {
        assertThatExceptionOfType(ArgumentNumberException.class)
            .isThrownBy(() -> LottoTicket.of(ticket));
    }

}
