package lotto.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    private static Stream<Arguments> count_matching_number() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4, 36, 39, 40), 6),
                Arguments.of(List.of(2, 3, 4, 36, 39, 45), 5),
                Arguments.of(List.of(2, 3, 4, 29, 39, 45), 4)
        );
    }

    @Test
    @DisplayName("중복숫자 존재시 에러")
    void check_duplicated_number() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoTicket.of(List.of(1, 3, 3, 36, 39, 40)));
    }

    @ParameterizedTest(name = "[{index}] [1,3,4,36,39,40] 와 {0} 비교 -> 같은 숫자 {1}개")
    @MethodSource
    @DisplayName("로또끼리 같은 숫자 세기")
    void count_matching_number(List<Integer> lottoNumbers, int expected) {
        LottoTicket lottoTicket = LottoTicket.of(List.of(2, 3, 4, 36, 39, 40));
        int result = lottoTicket.countOfMatch(LottoTicket.of(lottoNumbers));
        assertThat(expected).isEqualTo(result);
    }

    @ParameterizedTest(name = "[{index}] {0}원 입력 -> {1}개")
    @CsvSource({"2000,2", "4000,4", "10000,10"})
    @DisplayName("가격을 입력받아 로또생성")
    void make_lotto_tickets(int paid, int count) {
        LottoTickets lottoTickets = LottoTicket.of(new Money(paid));
        assertThat(lottoTickets.size()).isEqualTo(count);
    }
}
