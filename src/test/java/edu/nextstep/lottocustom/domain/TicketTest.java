package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.CustomNumbersMaker;
import edu.nextstep.lottocustom.exception.NumbersIllegalArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketTest {

    @ParameterizedTest(name = "Ticket 생성 성공")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "40, 41, 42, 43, 44, 45"}) // given
    void of_success(String numbers) {
        // when
        Ticket ticket = Ticket.madeBy(new CustomNumbersMaker(numbers));

        // then
        assertThat(ticket.stream().collect(Collectors.toList()))
                .isEqualTo(new CustomNumbersMaker(numbers).create());
    }

    @ParameterizedTest(name = "Ticket 생성 실패 : 개수 미만 or 초과")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"}) // given
    void of_fail_length_of_numbers(String numbers) {
        // when, then
        assertThatThrownBy(() -> Ticket.madeBy(new CustomNumbersMaker(numbers)))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining(Ticket.LENGTH_OF_NUMBERS_EXCEPTION_MESSAGE);
    }
}
