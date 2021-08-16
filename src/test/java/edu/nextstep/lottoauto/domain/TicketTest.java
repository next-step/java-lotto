package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.NumbersIllegalArgumentException;
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
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("입력 숫자 개수 미달 or 초과.");
    }

    @ParameterizedTest(name = "Ticket 생성 실패 : 숫자 허용 범위 초과")
    @CsvSource({"0, 5", "41, 46"})
    void of_fail_out_of_ranges(int numFrom, int numTo) {
        // given
        List<Integer> numbers = createNumbersFromTo(numFrom,numTo);

        // when, then
        assertThatThrownBy(() -> Ticket.of(numbers))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining("지정 가능 숫자 범위 초과.");
    }

    @ParameterizedTest(name = "동일한 숫자 개수 출력 [{index}] {0}부터 {1}까지 동일숫자개수 {2}")
    @CsvSource({"1, 6, 6", "2, 7, 5", "3, 8, 4", "4, 9, 3"})
    void countMatchingNumbers(int numFrom, int numTo, int result) {
        // given
        Ticket ticket = Ticket.of(createNumbersFromTo(1, 6));
        List<Integer> winningNumbers = createNumbersFromTo(numFrom, numTo);

        // when
        int countOfMatching = ticket.countMatchingNumbers(winningNumbers);

        // then
        assertThat(countOfMatching).isEqualTo(result);
    }

    private List<Integer> createNumbersFromTo(int numFrom, int numTo) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = numFrom; i <= numTo; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
