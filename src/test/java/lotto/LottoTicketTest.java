package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class LottoTicketTest {

    @DisplayName(value = "티켓 번호가 6개가 생성되었는지 체크")
    @Test
    void 로또_티켓_1개_생성() {
        // when
        List<Number> ticket = Arrays.asList(Number.newNumber(1),
                                            Number.newNumber(2),
                                            Number.newNumber(3),
                                            Number.newNumber(4),
                                            Number.newNumber(5),
                                            Number.newNumber(6));
        LottoTicket autoTicket = LottoTicket.newTicket(ticket);

        // then
        assertThat(autoTicket.size()).isEqualTo(LottoTicket.LOTTO_TICKET_SIZE);
    }

    @TestFactory
    Stream<DynamicTest> 예외_테스트() {
        int countOfMatch = 5;

        return Stream.of(
                dynamicTest("로또 번호가 중복되면 예외", () -> {
                    // given
                    List<Number> ticket = Arrays.asList(Number.newNumber(1),
                            Number.newNumber(2),
                            Number.newNumber(3),
                            Number.newNumber(4),
                            Number.newNumber(5),
                            Number.newNumber(5));

                    // when
                    assertThatThrownBy(() -> {
                        LottoTicket.newTicket(ticket);
                        // then
                    }).isInstanceOf(IllegalArgumentException.class);
                }),

                dynamicTest("로또 번호가 6개가 아니면 예외", () -> {
                    // given
                    List<Number> ticket = Arrays.asList(Number.newNumber(1),
                            Number.newNumber(2),
                            Number.newNumber(3),
                            Number.newNumber(4),
                            Number.newNumber(5),
                            Number.newNumber(6),
                            Number.newNumber(7));

                    // when
                    assertThatThrownBy(() -> {
                        LottoTicket.newTicket(ticket);
                        // then
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }
}