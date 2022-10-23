package lotto.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    @DisplayName("중복숫자 존재시 에러")
    void check_duplicated_number() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoTicket.of(new int[]{1, 3, 3, 36, 39, 40}));
    }

    @Test
    @DisplayName("로또끼리 같은 숫자 세기")
    void count_matching_number() {
        LottoTicket lottoTicket = LottoTicket.of(new int[]{1, 3, 4, 36, 39, 40});
        int match = lottoTicket.countMatch(LottoTicket.of(new int[]{1, 3, 5, 37, 39, 40}));
        assertThat(match).isEqualTo(4);
    }

    @ParameterizedTest(name = "[{index}] {0}원 입력 = {1}개")
    @CsvSource({"2000,2", "4000,4", "10000,10"})
    @DisplayName("가격을 입력받아 로또생성")
    void make_lotto_tickets(int money, int count) {
        LottoTickets lottoTickets = LottoTicket.of(money);
        assertThat(lottoTickets.size()).isEqualTo(count);
    }
}
