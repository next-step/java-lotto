package lotto.backend.domain;

import lotto.backend.domain.generator.AutoNumberGenerator;
import lotto.backend.domain.generator.CustomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

    private static Stream<Arguments> count_matching_number() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4, 36, 39, 40), 6),
                Arguments.of(List.of(2, 3, 4, 36, 39, 45), 5),
                Arguments.of(List.of(2, 3, 4, 29, 39, 45), 4));
    }

    @Test
    @DisplayName("중복숫자 존재시 에러")
    void check_duplicated_number() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoTicket.create(List.of(1, 2, 3, 4, 5, 5)));
    }

    @ParameterizedTest(name = "[{index}] [1,3,4,36,39,40] 와 {0} 비교 -> 같은 숫자 {1}개")
    @MethodSource
    @DisplayName("로또끼리 같은 숫자 세기")
    void count_matching_number(List<Integer> lottoNumbers, int expected) {
        LottoTicket lottoTicket = LottoTicket.create(List.of(2, 3, 4, 36, 39, 40));
        int result = lottoTicket.countOfMatch(LottoTicket.create(lottoNumbers));
        assertThat(expected).isEqualTo(result);
    }

    @Test
    @DisplayName("자동번호 생성인지 판별")
    void auto_ticket() {
        LottoTicket lottoTicket = LottoTicket.create(new AutoNumberGenerator());
        assertThat(lottoTicket.isAutoType()).isEqualTo(true);
    }

    @Test
    @DisplayName("수동번호 생성인지 판별")
    void custom_ticket() {
        List numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = LottoTicket.create(new CustomNumberGenerator(numbers));
        assertThat(lottoTicket.isAutoType()).isEqualTo(false);
    }
}
