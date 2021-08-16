package edu.nextstep.lottoauto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TicketTest {

    @Test
    @DisplayName("Ticket 생성 성공")
    void of_success() {
        // given
        List<Integer> numbers = createNumbersFromTo(1,6);

        // when
        Ticket ticket = Ticket.of(numbers);

        // then
        assertThat(ticket.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest(name = "Ticket 생성 실패 : 개수 미만 or 초과")
    @CsvSource({"1, 5", "1, 7"})
    void of_fail_number_of_numbers(int numFrom, int numTo) {
        // given
        List<Integer> numbers = createNumbersFromTo(numFrom,numTo);

        // when, then
        assertThatThrownBy(() -> Ticket.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Ticket 생성 실패 : 숫자 허용 범위 초과")
    @CsvSource({"0, 5", "41, 46"})
    void of_fail_out_of_ranges(int numFrom, int numTo) {
        // given
        List<Integer> numbers = createNumbersFromTo(numFrom,numTo);

        // when, then
        assertThatThrownBy(() -> Ticket.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
