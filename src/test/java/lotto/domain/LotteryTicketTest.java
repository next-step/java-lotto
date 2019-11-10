package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by yusik on 2019/11/05.
 */
class LotteryTicketTest {

    private LotteryTicket ticket;

    @BeforeEach
    void setUp() {
        // given
        ticket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("복권 숫자 갯수")
    @Test
    void getNumbers() {

        // when
        List<LotteryNumber> numbers = ticket.getNumbers();

        // then
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("복권 숫자 변조 방지")
    @Test
    void addNumbers() {

        // when
        List<LotteryNumber> numbers = ticket.getNumbers();

        // then
        assertThrows(UnsupportedOperationException.class, () -> numbers.add(LotteryNumber.of(1)));
    }

    @DisplayName("복권 숫자 범위 정상")
    @Test
    void validateNumber() {
        // when
        List<LotteryNumber> numbers = ticket.getNumbers();

        // then
        assertThat(numbers.contains(LotteryNumber.of(1))).isTrue();
    }

    @DisplayName("유효성 검사 실패: 범위")
    @Test
    void outOfRange() {
        assertThatThrownBy(() -> LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("복권 번호의 범위는 \\[\\d+, \\d+\\] 입니다.");
    }

    @DisplayName("유효성 검사 실패: 사이즈")
    @Test
    void sizeOver() {
        assertThatThrownBy(() -> LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("복권 번호는 [0-9]+개 입니다.");
    }

    @DisplayName("유효성 검사 실패: 숫자 중복")
    @Test
    void duplicate() {
        assertThatThrownBy(() -> LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("중복");
    }
}