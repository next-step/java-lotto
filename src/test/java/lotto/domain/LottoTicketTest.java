package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.TicketSizeOutBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTicketTest {

    static Stream<Arguments> generateTicketSuccess() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
            Arguments.of(new ArrayList<>(Arrays.asList(4, 10, 20, 30, 44, 45)))
        );
    }

    static Stream<Arguments> generateTicketException() {
        return Stream.of(
            Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1))),
            Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 44, 44, 40)))
        );
    }


    @ParameterizedTest
    @DisplayName("성공생성")
    @MethodSource("generateTicketSuccess")
    void createSuccess(List<Integer> args) {
        assertThat(LottoTicket.from(args)).isInstanceOf(LottoTicket.class);
    }

    @ParameterizedTest
    @DisplayName("중복 제거로 인한 예외처리")
    @MethodSource("generateTicketException")
    void lottoTicketSizeException(List<Integer> args) {
        assertThatExceptionOfType(TicketSizeOutBoundException.class)
            .isThrownBy(() -> LottoTicket.from(args));
    }

}
