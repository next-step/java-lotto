package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by yusik on 2019/11/05.
 */
class LotteryTicketTest {

    private LotteryTicket ticket;

    @BeforeEach
    void setUp() {
        // given
        ticket = new LotteryTicket(Lists.newArrayList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("복권 숫자 갯수")
    @Test
    void getNumbers() {

        // when
        List<Integer> numbers = ticket.getNumbers();

        // then
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("복권 숫자 변조 방지")
    @Test
    void addNumbers() {

        // when
        List<Integer> numbers = ticket.getNumbers();

        // then
        assertThrows(UnsupportedOperationException.class, () -> numbers.add(1));
    }

    @DisplayName("복권 숫자 범위")
    @Test
    void validateNumber() {

        // when
        List<Integer> numbers = ticket.getNumbers();

        // then
        boolean allMatch = numbers.stream()
                .allMatch(integer -> integer > 0 && integer <= 45);
        assertThat(allMatch).isTrue();
    }
}